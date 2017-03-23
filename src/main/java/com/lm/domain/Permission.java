package com.lm.domain;

/**
 * 权限实体
 * Created by Louie on 2017-03-23.
 */
public class Permission {

    private Integer id;
    private String permissionName;  // 权限名称
    private String roleId;          // 角色id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
