package com.xlx.shiro.controller;

import com.xlx.shiro.common.util.ShiroUtil;
import com.xlx.shiro.dto.LoginDTO;
import com.xlx.shiro.dto.ResultDTO;
import com.xlx.shiro.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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
		logger.info("===================/login");
		UsernamePasswordToken upToken = new UsernamePasswordToken(loginDTO.getUsername(), loginDTO.getPassword(), loginDTO.getRememberMe());
		Subject subject = ShiroUtil.getSubject();
		User user = (User) subject.getPrincipal();
		try {
			subject.login(upToken);
			logger.info( "User [" + user.getUserName() + "] logged in successfully." );
			return ResultDTO.success("登录成功",user);
		}catch (UnauthenticatedException | LockedAccountException | ExcessiveAttemptsException ex){
			logger.error("登陆失败:[{}]", ex.getMessage());
			return ResultDTO.failed(ex.getMessage());
		}catch (AuthenticationException e) {
			logger.error("登陆失败:[{}]", e.getMessage());
			return ResultDTO.failed("用户名或密码错误",loginDTO);
		}
	}


	/**
	 * 登出
	 */
	@GetMapping("/logout")
	public String logout(){
		ShiroUtil.getSubject().logout();
		return "redirect:/login";
	}




	/**
	 * 未授权
	 */
	@GetMapping("/unauthorized")
	public String unAuthorized() {

		return "unauthorized";
	}
}
