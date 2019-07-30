package com.demo.basic.controller;

import com.demo.basic.dto.ResultDTO;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常
 *
 * @author xielx on 2019/7/30
 */
//@Controller
//@RequestMapping("/error")
public class ExceptionController  implements ErrorController {
	@Override
	public String getErrorPath() {
		return "error";
	}


	public ModelAndView errorHTML(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("error");
		HttpStatus httpStatus = getStatus(request);
		ResultDTO resultDTO = null;
		if (httpStatus.is4xxClientError()){
			resultDTO = ResultDTO.failed(httpStatus.value(),"4xx错误");
		}else if (httpStatus.is5xxServerError()){
			resultDTO = ResultDTO.failed(httpStatus.value(),"服务器异常,请联系管理员");
		}
		mav.addObject("message",resultDTO);
		return mav;
	}

	private HttpStatus getStatus(HttpServletRequest request){

		Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");

		if (status == null){
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}

		try{
			return HttpStatus.valueOf(status);
		}catch (Exception e){
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}

	}

}
