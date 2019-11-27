package com.demo.basic.service;

import com.demo.basic.entity.Department;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * 部门:service层
 *
 * @author xielx at 2019/11/27 22:17
 */
@Service
@Validated
public class DepartmentService {
    
    public void saveDept(@Valid Department department) {
        System.out.println("部门添加成功");
    }
}
