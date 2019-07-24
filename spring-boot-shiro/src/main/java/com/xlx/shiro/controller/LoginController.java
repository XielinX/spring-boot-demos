package com.xlx.shiro.controller;

import com.xlx.shiro.common.util.ShiroUtil;
import com.xlx.shiro.dto.LoginDTO;
import com.xlx.shiro.dto.ResultDTO;
import com.xlx.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 登录
 *
 * @author xielx on 2019/7/22
 */
@RestController
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);


	@ResponseBody
	@PostMapping("/login")
	public ResultDTO login(LoginDTO loginDTO) {
		UsernamePasswordToken upToken = new UsernamePasswordToken(loginDTO.getUserName(), loginDTO.getPassword(), loginDTO.getRememberMe());
		Subject subject = ShiroUtil.getSubject();
		try {
			subject.login(upToken);
			return ResultDTO.success();
		} catch (AuthenticationException e) {
			logger.error("登陆失败:[{}]", e.getMessage());
			return ResultDTO.success(e.getMessage());
		}
	}


	/**
	 * 未授权
	 */
	@GetMapping("/unAuth")
	public String unauthorized() {
		return "unauthorized";
	}
}
