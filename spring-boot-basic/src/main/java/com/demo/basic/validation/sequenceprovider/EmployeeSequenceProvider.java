package com.demo.basic.validation.sequenceprovider;

import com.demo.basic.entity.Employee;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * 据对象状态动态重新定义默认组序列。
 * @author xielx at 2019/11/30 21:21
 */
public class EmployeeSequenceProvider implements DefaultGroupSequenceProvider<Employee> {
    
    @Override
    public List<Class<?>> getValidationGroups(Employee employee) {
        // 添加默认分组
        List<Class<?>> defaultGroupSequence = new ArrayList<>();
        defaultGroupSequence.add(Employee.class);
    
        /**
         * age:20~25,初级组
         * age:25~30,中级组
         */
        if (employee != null) {
            if (20 <= employee.getAge() && employee.getAge() <= 25) {
                defaultGroupSequence.add(Employee.JuniorTitle.class);
            } else if (25 < employee.getAge() && employee.getAge() <= 30) {
                defaultGroupSequence.add(Employee.MiddleTitle.class);
            }
        }
        // 最后就是{default.class,?} ?=初级组或者中级组或者没有
        return defaultGroupSequence;
    }
    
}