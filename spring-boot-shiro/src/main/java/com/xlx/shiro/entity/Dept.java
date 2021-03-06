package com.xlx.shiro.entity;

import java.io.Serializable;
import java.util.Date;

public class Dept implements Serializable {
    private Long deptId;

    private String deptName;

    private Long parentId;

    private String parentIds;

    private Boolean available;

    private Date gmtCreate;

    private Date gmtModified;

    public Dept(Long deptId, String deptName, Long parentId, String parentIds, Boolean available, Date gmtCreate, Date gmtModified) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.parentId = parentId;
        this.parentIds = parentIds;
        this.available = available;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public Dept() {
        super();
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
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