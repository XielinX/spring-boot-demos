package com.xlx.shiro.controller;

import com.xlx.shiro.common.util.ShiroUtil;
import com.xlx.shiro.dto.LoginDTO;
import com.xlx.shiro.dto.ResultDTO;
import com.xlx.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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

	@ResponseBody
	@PostMapping("/login")
	public ResultDTO login(LoginDTO loginDTO){
		UsernamePasswordToken upToken = new UsernamePasswordToken(loginDTO.getUserName(),loginDTO.getPassword(),loginDTO.getRememberMe());
		Subject subject = ShiroUtil.getSubject();
		try{
			subject.login(upToken);
			return ResultDTO.success();
		}catch (AuthenticationException e){
			logger.error("登陆失败:[{}]",e.getMessage());
			return ResultDTO.success(e.getMessage());
		}
	}
}
