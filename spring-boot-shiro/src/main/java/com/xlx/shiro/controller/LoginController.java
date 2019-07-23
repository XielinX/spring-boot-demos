package com.xlx.shiro.controller;

import com.xlx.shiro.dto.ResultDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 登录
 * @author xielx on 2019/7/22
 */
@RestController
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@PostMapping("/login")
	public ResultDTO login(@RequestParam(name = "username") String userName,
												 @RequestParam(name = "password") String password,
												 @RequestParam(name = "rememberMe", required = false) Boolean rememberMe) {

		UsernamePasswordToken token = new UsernamePasswordToken(userName, password, rememberMe);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return ResultDTO.success();
		} catch (AuthenticationException e) {
			logger.error("登录失败:[{}]", e.getMessage());
			return ResultDTO.failed(e.getMessage());
		}
	}


	/**
	 * 未授权
	 */
	@GetMapping("/unAuth")
	public String unauthorized(){
		return "unauthorized";
	}
}
