package com.lm.controller;

import com.lm.domain.Human;
import com.lm.domain.User;
import com.lm.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制层
 * Created by Louie on 2017-03-22.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录界面跳转
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "login";
    }

    /**
     * 用户登录
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {

        // 获取subject对象
        Subject subject = SecurityUtils.getSubject();
        // 实例化用户名密码令牌
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            // 使用subject对象进行登陆
            subject.login(token);
            // 获取session
            Session session = subject.getSession();
            // 输出session
            System.out.println("sessionId:" + session.getId() + ";sessionHost:" + session.getHost() +";sessionTimeout:%s" + session.getTimeout());
            session.setAttribute("info", "session的数据");
            return "redirect:success";
        } catch (Exception e) {
            // 验证失败
            e.printStackTrace();
            request.setAttribute("user", user);
            request.setAttribute("errorMsg", "用户名或密码错误");
            return "login";
        }
    }

    /**
     * 权限验证失败跳转
     * @return
     */
    @RequestMapping("unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    /**
     * 显示所有human
     * @param request
     * @return
     */
    @RequestMapping("/success")
    public String listAll(HttpServletRequest request) {
        request.setAttribute("humans", this.userService.queryAll());
        return "list";
    }

    /**
     * form界面跳转
     * @return
     */
    @RequestMapping("/form")
    public String form() {
        return "form";
    }

    /**
     * 新增human
     * @param human
     * @return
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(Human human) {
        this.userService.addHuman(human);
        System.out.println(human.toString());
        return "redirect:success";
    }

    /**
     * 修改human
     * @param human
     * @return
     */
    @RequestMapping("/update")
    public String update(Human human) {
        this.userService.updateHuman(human);
        return "redirect:success";
    }

    /**
     * 删除human
     * @param id
     * @return
     */
    @RequestMapping("/del/{id}")
    public String del(@PathVariable Integer id) {
        System.out.println(id);
        this.userService.delHuman(id);
        return "redirect:/user/success";
    }

    /**
     * 修改界面跳转并数据回显
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, HttpServletRequest request) {
        Human human = this.userService.queryById(id);
        request.setAttribute("human", human);
        return "form";
    }

    /**
     * 注销用户
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            // 销毁session，清理缓存
            subject.logout();
        }
        return "redirect:index";
    }
}
