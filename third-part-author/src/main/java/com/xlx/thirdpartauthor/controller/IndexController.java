package com.xlx.thirdpartauthor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * index
 *
 * @author xielx at 2020/3/7 23:45
 */
@Controller
public class IndexController {
    
    
    @GetMapping("/")
    public String indexHtml(){
        return "login";
    }
    
    @GetMapping("/login")
    public String loginHtml(){
        return "login";
    }
}
