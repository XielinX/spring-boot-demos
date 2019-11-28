package com.demo.basic.service;

import com.demo.basic.entity.Employee;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 员工:service层
 *
 * @author xielx at 2019/11/27 22:19
 */
//@Validated // 它的每个实现类都会校验
public interface IEmployeeService {
    
    void addEmployee(@Valid Employee employee);
    
    // 返回值不能为null
    @NotNull Employee getEmployeeById(Long id);
    
    
    void updateEmployee(@Valid Employee employee);
}
