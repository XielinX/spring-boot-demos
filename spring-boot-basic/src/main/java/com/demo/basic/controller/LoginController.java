package com.demo.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录
 *
 * @author xielx on 2019/7/29
 */
@Controller
public class LoginController {

	private static final String NAME = "admin";
	private static final String PWD = "admin";

	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	
	@PostMapping("/login")
	public String login(@RequestParam(name = "username") String name,
											@RequestParam(name = "password") String pwd,
											@RequestParam(name = "rememberMe",required = false) Boolean remember,
											HttpServletRequest request){

		if (NAME.equals(name) && PWD.equals(pwd)){
			request.getSession().setAttribute("username",name);
			return "redirect:/index";
		}

		request.setAttribute("msg","用户名或密码错误");
		return "login";
	}
}
