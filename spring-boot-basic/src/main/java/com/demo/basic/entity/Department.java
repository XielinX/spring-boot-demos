package com.demo.basic.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 部门实体类
 * id   主键,默认为null(自增)
 * parentId 父id,不能为null,大于0
 * deptName 部门名称,不为空(null和""),长度大于0
 * createTime   创建时间,不能为未来时间
 *
 * @author xielx at 2019/11/26 22:30
 */
public class Department implements Serializable {
    
    /**
     * 主键
     */
    @Null
    private Integer id;
    /**
     * 父id
     */
    @NotNull
    private Integer parentId;
    /**
     * 部门名称
     */
    @NotBlank
    private String deptName;
    /**
     * 创建时间
     */
    @NotNull
    @PastOrPresent
    private LocalDateTime createTime;
    
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getParentId() {
        return parentId;
    }
    
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    
    public String getDeptName() {
        return deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
