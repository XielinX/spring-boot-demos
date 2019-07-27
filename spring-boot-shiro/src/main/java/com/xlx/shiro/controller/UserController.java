package com.xlx.shiro.controller;

import com.xlx.shiro.entity.User;
import com.xlx.shiro.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * controller:user
 *
 * @author xielx on 2019/7/24
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
	private UserService userService;

	@RequiresPermissions("system:user:list")
	@GetMapping("/list")
	public List<User> listUserByPage(@RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
																	 @RequestParam(name = "size",required = false,defaultValue = "5") Integer size){

		List<User> userList = userService.listUserPage(page,size);
		return userList;
	}

}
