package com.demo.basic.config;

import com.demo.basic.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置注解
 *
 * @author xielx on 2019/7/25
 */
@Configuration
public class BeanConfig {

	@Bean
	public UserService userService(){
		return new UserService();
	}
}
