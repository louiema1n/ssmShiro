package com.lm.service.impl;

import com.lm.dao.UserDao;
import com.lm.domain.Human;
import com.lm.domain.User;
import com.lm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Louie on 2017-03-22.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserByUserName(String userName) {
        return this.userDao.selectUserByUserName(userName);
    }

    public Set<String> getRolesByUserName(String userName) {
        return this.userDao.selectRolesByUserName(userName);
    }

    public Set<String> getPermissionByUserName(String userName) {
        return this.userDao.selectPermissionByUserName(userName);
    }

    public List<Human> queryAll() {
        return this.userDao.selectAll();
    }

    public void addHuman(Human human) {
        this.userDao.insertHuman(human);
    }

    public void updateHuman(Human human) {
        this.userDao.updateHuman(human);
    }

    public void delHuman(int id) {
        this.userDao.deleteHuman(id);
    }

    public Human queryById(int id) {
        return this.userDao.queryById(id);
    }
}
