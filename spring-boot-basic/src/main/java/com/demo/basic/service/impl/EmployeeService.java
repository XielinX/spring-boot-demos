package com.demo.basic.service.impl;

import com.demo.basic.entity.Employee;
import com.demo.basic.service.IEmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * IEmployee实现类
 *
 * @author xielx at 2019/11/27 22:21
 */
@Service
@Validated
public class EmployeeService implements IEmployeeService {
    
    /**
     * 重写方法里的参数,不能重新定义参数约束配置
     * @param employee 员工
     */
    @Override
    public void addEmployee(Employee employee) {
        // 业务处理
    }
    
    @Override
    public @NotNull Employee getEmployeeById(Long id) {
        return null;
    }
}
