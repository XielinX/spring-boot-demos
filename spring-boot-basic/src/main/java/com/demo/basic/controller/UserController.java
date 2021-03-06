package com.demo.basic.controller;

import com.demo.basic.exception.UserNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户
 *
 * @author xielx on 2019/7/30
 */
@Slf4j
@Controller
public class UserController {
    
    
    @GetMapping("/user/list")
    @ResponseBody
    public String list(@RequestParam(name = "name") String query) {
        if ("zh".equals(query)) {
            throw new UserNotExistException("用户异常错误");
        }
        return "user/list";
    }
    
    
    @GetMapping("/user/test")
    public String test() {
        System.out.println(10/0);
        return "index";
    }
    
}
