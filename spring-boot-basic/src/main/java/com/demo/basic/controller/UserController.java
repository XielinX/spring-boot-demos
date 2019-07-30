package com.demo.basic.controller;

import com.demo.basic.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户
 *
 * @author xielx on 2019/7/30
 */
@Controller
public class UserController {


	@GetMapping("/user/list")
	public String list(@RequestParam(name = "name") String query ){
   if ("zh".equals(query)){
   	throw new MyException("用户异常错误");
	 }
		return "user/list";
	}
}