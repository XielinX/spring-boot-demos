package com.xlx.sc.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * indes
 *
 * @author xielx at 2020/1/2 15:36
 */
@RestController
public class IndexController {
    
    @GetMapping("/index")
    public String index() {
        return "hello spring security";
    }
    
    
    @GetMapping("/index")
    public Map<String,String> busy() {
        Map<String,String> map = new HashMap<>();
        map.put("question1","为什么不出现默认的表单验证");
        map.put("question2","为什么不出现默认的表单验证");
        return  map;
    }
    
}
