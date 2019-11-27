package com.demo.basic.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import java.util.List;

/**
 * 员工实体类
 *
 * @author xielx at 2019/11/27 21:06
 */
public class Employee {
    
    /**
     * 主键
     */
    @Null
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
    private List<@Valid Employee> employeeList;
    
    
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
    
    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
