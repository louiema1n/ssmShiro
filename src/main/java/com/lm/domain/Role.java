package com.lm.domain;

/**
 * 角色实体
 * Created by Louie on 2017-03-23.
 */
public class Role {

    private Integer id;
    private String roleName;    // 角色名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
