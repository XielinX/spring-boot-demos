package com.demo.basic.controller;

import com.demo.basic.dto.ResultDTO;
import com.demo.basic.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理:
 * catch下的异常不处理
 * @author xielx at 2019/11/25 19:22
 */
@Slf4j
@ControllerAdvice
public class MyExceptionHandler {
    
    
    /**
     * 自适应处理自定义异常
     * @param e 异常对象
     * @return 统一结果
     */
    @ExceptionHandler(MyException.class)
    public String handleMyException(MyException e, HttpServletRequest request){
        request.setAttribute("javax.servlet.error.status_code",500);
        Map<String,Object> map = new HashMap<>();
        map.put("code","user not exist");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }
    
    
    /**
     * 未捕获异常
     * @param e Exception
     * @return 统一结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultDTO handleException(Exception e){
        return ResultDTO.failed(1009,e.getMessage());
    }
}
