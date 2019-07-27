package com.xlx.shiro.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Resource implements Serializable {
    private Long resourceId;

    private String name;

    private String icon;

    private String type;

    private String url;

    private Long parentId;

    private String parentIds;

    private String permission;

    private Boolean available;

    private Date gmtCreate;

    private Date gmtModified;


    public Resource(Long resourceId, String name, String icon, String type, String url, Long parentId, String parentIds, String permission, Boolean available, Date gmtCreate, Date gmtModified) {
        this.resourceId = resourceId;
        this.name = name;
        this.icon = icon;
        this.type = type;
        this.url = url;
        this.parentId = parentId;
        this.parentIds = parentIds;
        this.permission = permission;
        this.available = available;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }


}