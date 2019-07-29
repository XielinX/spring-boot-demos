package com.demo.basic.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @author xielx on 2019/7/29
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object obj = request.getSession().getAttribute("user");
		if (obj == null){

			request.setAttribute("msg","请先登录");
			request.getRequestDispatcher("/login").forward(request,response);
			//response.sendRedirect("/login");
			return false;
		}

		return true;
	}
}
