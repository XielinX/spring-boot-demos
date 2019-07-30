package com.demo.basic.exception;

import com.alibaba.fastjson.JSON;
import com.demo.basic.dto.ResultDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 全局异常处理
 * 异常发生会先走这里
 * 1.application/json:json格式显示
 * 2.text/html:浏览器视图显示,映射url="error"到Controller处理
 * @author xielx on 2019/7/30
 */
@ControllerAdvice
public class MyExceptionHandler {


	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(HttpServletRequest request, HttpServletResponse response, Exception e) {

		//json格式
		String contentType = request.getContentType();
		if ("application/json".equals(contentType)) {
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.setStatus(200);
			PrintWriter out;
			try {
				out = response.getWriter();
				out.write(JSON.toJSONString(ResultDTO.failed(e.getMessage())));
				out.close();
			} catch (IOException ex) {
				//
			}

			return null;
		}

		//html格式
		ModelAndView mav = new ModelAndView("error/error");

		mav.addObject("message",e.getMessage());
		return mav;
	}
}