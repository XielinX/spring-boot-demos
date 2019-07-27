package com.demo.basic.config;

import com.demo.basic.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置注解
 * @Bean :
 *   设置了name属性,bean名称就是name属性值
 *   未设置,默认就是方法名称
 * @author xielx on 2019/7/25
 */
@Configuration
public class BeanConfig {

	@Bean("userService")
	public UserService getUserService(){
		return new UserService();
	}
}
