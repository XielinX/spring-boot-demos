package com.demo.basic.controller;

import com.demo.basic.dto.ResultDTO;
import com.demo.basic.entity.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * employee
 *
 * @author xielx at 2019/11/27 21:15
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {
    
    
    @PostMapping("/add")
    public ResultDTO addEmp(@RequestBody  @Valid Employee employee){
        return ResultDTO.success();
    }
}
