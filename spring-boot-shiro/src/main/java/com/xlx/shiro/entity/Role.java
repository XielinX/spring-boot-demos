package com.xlx.shiro.entity;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
    private Long roleId;

    private String roleKey;

    private String roleName;

    private Boolean available;

    private Date gmtCreate;

    private Date gmtModified;

    public Role(Long roleId, String roleKey, String roleName, Boolean available, Date gmtCreate, Date gmtModified) {
        this.roleId = roleId;
        this.roleKey = roleKey;
        this.roleName = roleName;
        this.available = available;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public Role() {
        super();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey == null ? null : roleKey.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}