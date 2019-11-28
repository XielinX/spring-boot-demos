package com.demo.basic.controller;

import com.demo.basic.dto.ResultDTO;
import com.demo.basic.entity.Job;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author xielx at 2019/11/28 20:16
 */
@RestController
@RequestMapping("/job")
@Validated
public class JobController {
    
    @PostMapping("/add")
    public ResultDTO addJob(@RequestBody @Valid Job job){
        //
        return ResultDTO.success();
    }
}
