package com.xlx.shiro.entity;

import java.io.Serializable;

public class RoleMenu implements Serializable {
    private Long id;

    private Long roleId;

    private Long resourceId;

    public RoleMenu(Long id, Long roleId, Long resourceId) {
        this.id = id;
        this.roleId = roleId;
        this.resourceId = resourceId;
    }

    public RoleMenu() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}