package com.demo.basic.config.webmvc;

import com.demo.basic.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * mvc
 *
 * @author xielx on 2019/7/26
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {


	/**
	 * 视图返回,类似Controller方法
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
	}


	/**
	 * 静态资源
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/static/**");
	}

	/**
	 * 拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
						.excludePathPatterns("/static/**","/","/login","/login.html","/error")
						.addPathPatterns("/**");
	}

	/**
	 * MyLocalResolver的自动注入
	 */
	@Bean
	public LocaleResolver localeResolver(){
		return new MyLocalResolver();
	}


}
