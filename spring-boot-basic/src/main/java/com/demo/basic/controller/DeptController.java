package com.demo.basic.controller;

import com.demo.basic.entity.Department;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 部门controller
 *
 * @author xielx at 2019/11/26 22:40
 */
@RestController
@RequestMapping("/dept")
@Validated // 表示本类开启验证功能
public class DeptController {
    
    /**
     * 新增
     * @param dept 部门
     * @return String
     */
    @PostMapping("/add")
    public String addDept(@RequestBody @Valid Department dept){
        // todo something
        return "ok";
    }
}
