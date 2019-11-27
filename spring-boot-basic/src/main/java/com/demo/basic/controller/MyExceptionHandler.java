package com.demo.basic.controller;

import com.demo.basic.dto.ResultDTO;
import com.demo.basic.enums.ErrorCodeEnum;
import com.demo.basic.exception.UserNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 全局异常处理:
 * catch下的异常不处理
 *
 * @author xielx at 2019/11/25 19:22
 */
@Slf4j
@ControllerAdvice(basePackages = "com.demo.basic.controller")
public class MyExceptionHandler {
    
    
    /**
     * 自适应处理自定义异常
     *
     * @param e 异常对象
     * @return 统一结果
     */
    /*@ExceptionHandler(UserNotExistException.class)
    public String handleMyException(UserNotExistException e, HttpServletRequest request) {
        request.setAttribute("javax.servlet.error.status_code", 500);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user not exist");
        map.put("message", e.getMessage());
        request.setAttribute("ext", map);
        return "forward:/error";
    }*/


    @ExceptionHandler(UserNotExistException.class)
    public String handleMyException(UserNotExistException e, HttpServletRequest request) {
        request.setAttribute("javax.servlet.error.status_code", 500);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user not exist");
        map.put("message", e.getMessage());
        request.setAttribute("ext", map);
        return "forward:/error";
    }
    
    /**
     * 方法参数校验异常
     *
     * @param e MethodArgumentNotValidException
     * @return 统一返回结果
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultDTO handleMethodException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> collect = null;
        if (bindingResult.hasErrors()){
            collect = bindingResult.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            log.error("MethodArgumentNotValidException are:[{}]", collect);
        }
        return ResultDTO.failed(ErrorCodeEnum.PARAM_ERROR,collect);
    }
    
    /**
     * 未捕获异常
     *
     * @param e Exception
     * @return 统一结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultDTO handleException(Exception e) {
        log.error("unknown error message is: [{}]", e.getMessage());
        return ResultDTO.failed(ErrorCodeEnum.UNKNOWN_ERROR);
    }
}
