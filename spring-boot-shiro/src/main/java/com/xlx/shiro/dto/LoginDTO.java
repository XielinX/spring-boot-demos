package com.xlx.shiro.dto;

import lombok.Data;

/**
 * 登录dto
 *
 * @author xielx on 2019/7/24
 */
@Data
public class LoginDTO {


	private String username;

	private String password;

	private Boolean rememberMe = Boolean.FALSE;


}
