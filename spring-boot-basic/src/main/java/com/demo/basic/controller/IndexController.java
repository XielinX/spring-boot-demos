package com.demo.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * index
 *
 * @author xielx on 2019/7/26
 */
@RestController
public class IndexController {


	@GetMapping("/")
	public String index(){
		return "index";
	}
}
