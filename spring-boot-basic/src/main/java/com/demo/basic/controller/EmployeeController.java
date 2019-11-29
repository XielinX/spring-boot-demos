package com.demo.basic.controller;

import com.demo.basic.dto.ResultDTO;
import com.demo.basic.entity.Employee;
import com.demo.basic.service.IEmployeeService;
import com.demo.basic.validation.ValidList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.List;

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
    
    @PostMapping("/list")
    public ResultDTO addEmpByBatch(@RequestBody  @ValidList(grouping = {Employee.Add.class, Default.class},quickFail = true) List<Employee> empList){
        //
        return ResultDTO.success();
    }
    
    /*@PostMapping("/list")
    public ResultDTO addEmpByBatch(@RequestBody  @Validated({Employee.Add.class, Default.class}) List<Employee> empList){
        //
        return ResultDTO.success();
    }*/
    
    
    
    @GetMapping("/query")
    public ResultDTO findEmp(@RequestBody Long id){
        empService.getEmployeeById(id);
        return ResultDTO.success();
    }
}
