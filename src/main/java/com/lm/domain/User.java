package com.lm.domain;

/**
 * 用户实体
 * Created by Louie on 2017-03-23.
 */
public class User {

    private Integer id;
    private String userName;    // 用户名
    private String password;    // 密码

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
