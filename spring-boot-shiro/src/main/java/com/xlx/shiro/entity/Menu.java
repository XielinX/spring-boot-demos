package com.xlx.shiro.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Menu implements Serializable {
    private Long menuId;

    private String menuName;

    private String icon;

    private String type;

    private String url;

    private Long parentId;

    private String parentIds;

    private String permission;

    private Boolean available;

    private Date gmtCreate;

    private Date gmtModified;

    public Menu(Long menuId, String menuName, String icon, String type, String url, Long parentId, String parentIds, String permission, Boolean available, Date gmtCreate, Date gmtModified) {
        this.menuId = menuId;
        this.menuName = menuName;
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