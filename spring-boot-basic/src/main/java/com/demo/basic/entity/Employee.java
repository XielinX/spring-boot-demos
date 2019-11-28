package com.demo.basic.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.Default;

/**
 * 员工实体类
 * 分组:
 * 新增时:id为null,empName不为空
 * 修改时:id不为null,
 * @author xielx at 2019/11/27 21:06
 */
public class Employee {
    
    public interface Add extends Default {}
    public interface Update{}
    
    /**
     * 主键
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
    
    //@Valid
   // private List<@Valid Employee> employeeList;
    
    
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
    
   /* public List<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }*/
}
