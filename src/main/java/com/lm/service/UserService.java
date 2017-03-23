package com.lm.service;

import com.lm.domain.Human;
import com.lm.domain.User;

import java.util.List;
import java.util.Set;

/**
 * 业务
 * Created by Louie on 2017-03-22.
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 根据用户名查询角色信息
     * @param userName
     * @return
     */
    Set<String> getRolesByUserName(String userName);

    /**
     * 根据用户名查询权限信息
     * @param userName
     * @return
     */
    Set<String> getPermissionByUserName(String userName);

    /**
     * 查询所有human
     * @return
     */
    List<Human> queryAll();

    /**
     * 新增human
     * @param human
     */
    void addHuman(Human human);

    /**
     * 修改human
     * @param human
     */
    void updateHuman(Human human);

    /**
     * 删除human
     * @param id
     */
    void delHuman(int id);

    /**
     * 根据id查询Human
     * @param id
     * @return
     */
    Human queryById(int id);
}
