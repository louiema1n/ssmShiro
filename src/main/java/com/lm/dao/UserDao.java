package com.lm.dao;

import com.lm.domain.Human;
import com.lm.domain.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Louie on 2017-03-22.
 */
public interface UserDao {

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User selectUserByUserName(String userName);

    /**
     * 根据用户名查询角色信息
     * @param userName
     * @return
     */
    Set<String> selectRolesByUserName(String userName);

    /**
     * 根据用户名查询权限信息
     * @param userName
     * @return
     */
    Set<String> selectPermissionByUserName(String userName);

    /**
     * 查询所有human
     * @return
     */
    List<Human> selectAll();

    /**
     * 新增human
     * @param human
     */
    void insertHuman(Human human);

    /**
     * 修改human
     * @param human
     */
    void updateHuman(Human human);

    /**
     * 删除human
     * @param id
     */
    void deleteHuman(int id);

    /**
     * 根据id查询Human
     * @param id
     * @return
     */
    Human queryById(int id);
}
