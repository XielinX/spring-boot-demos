package com.demo.basic.controller;

import com.demo.basic.dto.ResultDTO;
import com.demo.basic.entity.Employee;
import com.demo.basic.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;

/**
 * employee
 *
 * @author xielx at 2019/11/27 21:15
 */
@RestController
@RequestMapping("/emp")
@Validated
public class EmployeeController {
    
    @Autowired
    private IEmployeeService empService;
    
    @PostMapping("/add")
    public ResultDTO addEmp(@RequestBody  @Validated({Employee.Add.class}) Employee employee){
        empService.addEmployee(employee);
        return ResultDTO.success();
    }
    
    
    @PostMapping("/update")
    public ResultDTO updateEmp(@RequestBody  @Validated({Employee.Update.class, Default.class}) Employee employee){
        empService.updateEmployee(employee);
        return ResultDTO.success();
    }
    
    
    
    @GetMapping("/query")
    public ResultDTO findEmp(@RequestBody Long id){
        empService.getEmployeeById(id);
        return ResultDTO.success();
    }
}
