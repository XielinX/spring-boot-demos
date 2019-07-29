package com.demo.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * index
 *
 * @author xielx on 2019/7/26
 */
@Controller
public class IndexController {


	@GetMapping("/login")
	public String home(){
		return "login";
	}

	@GetMapping("/index")
	public String index(){
		return "index";
	}



}
