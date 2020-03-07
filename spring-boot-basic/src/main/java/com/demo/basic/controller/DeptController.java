package com.demo.basic.controller;

import com.demo.basic.dto.ResultDTO;
import com.demo.basic.entity.Department;
import com.demo.basic.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门controller
 *
 * @author xielx at 2019/11/26 22:40
 */
@RestController
@RequestMapping("/dept")
//@Validated // 表示本类开启验证功能
public class DeptController {
    
    @Autowired
    private DepartmentService deptService;
    /**
     * 新增
     * @param dept 部门
     * @return String
     */
    @PostMapping("/add")
    public ResultDTO addDept(@RequestBody /*@Valid*/ Department dept){
        deptService.saveDept(dept);
        // todo something
        return ResultDTO.success();
    }
}
