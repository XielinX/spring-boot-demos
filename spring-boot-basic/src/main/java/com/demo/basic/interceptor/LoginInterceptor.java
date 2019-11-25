package com.demo.basic.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @author xielx on 2019/7/29
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 在Controller方法执行前执行
	 * 若设置了不拦截就不会走此方法,重定向要清楚拦截路径,防止死循环
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object obj = request.getSession().getAttribute("username");
		if (obj == null){

			request.setAttribute("msg","未登录,请先登录");
			request.getRequestDispatcher("/login").forward(request,response);

			//response.sendRedirect("/login");
			return false;
		}

		return true;
	}
}
