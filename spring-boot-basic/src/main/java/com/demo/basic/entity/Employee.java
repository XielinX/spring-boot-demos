package com.demo.basic.entity;

import com.demo.basic.validation.sequenceprovider.EmployeeSequenceProvider;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;

/**
 * 员工实体类
 * @author xielx at 2019/11/27 21:06
 */
@GroupSequenceProvider(EmployeeSequenceProvider.class)
public class Employee {
    
    // 为什么要写接口???
    public interface Add extends Default {}
    public interface Update{}
    
    /**
     * 主键
     * 分组:
     *  新增时:id为null,empName不为空
     *  修改时:id不为null,
     */
    @Null(groups = Add.class) // 新增时生效
    @NotNull(groups = Update.class) // 修改时生效
    private Long id;
    /**
     * 员工姓名
     */
    @NotEmpty
    private String empName;
    /**
     * 部门
     */
    @Valid
    private Department dept;
    
    /**
     * 年龄
     * age:20~25,title的开头"初级"
     * age:25~30,title的开头"中级"
     * 否则,其他
     */
    @NotNull
    private Integer age;
    
    public interface JuniorTitle{}
    public interface MiddleTitle{}
    
    
    @NotNull
    @Pattern(regexp = "^\u521d\u7ea7.*",groups = JuniorTitle.class) // 初级
    @Pattern(regexp = "^\u4e2d\u7ea7.*",groups = MiddleTitle.class) // 中级
    private String title;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmpName() {
        return empName;
    }
    
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    
    public Department getDept() {
        return dept;
    }
    
    public void setDept(Department dept) {
        this.dept = dept;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
}
