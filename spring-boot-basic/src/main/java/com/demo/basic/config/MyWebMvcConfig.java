package com.demo.basic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * mvc
 *
 * @author xielx on 2019/7/26
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {


	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
	}



}
