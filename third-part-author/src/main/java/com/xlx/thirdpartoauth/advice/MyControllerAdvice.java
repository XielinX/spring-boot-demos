package com.xlx.thirdpartoauth.advice;

import com.xlx.thirdpartoauth.dto.ResultDTO;
import com.xlx.thirdpartoauth.enums.ErrorCodeEnum;
import com.xlx.thirdpartoauth.exception.CustomizeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 全局异常捕获
 *
 * @author xielx at 2020/3/8 21:30
 */
@Slf4j
@ControllerAdvice
public class MyControllerAdvice {
    
    /**
     * 自定义异常处理
     * @param e 自定义异常
     * @return
     */
    @ExceptionHandler(CustomizeException.class)
    @ResponseBody
    public ResultDTO handleCustomizeException(CustomizeException e){
        return ResultDTO.failed(e.getCode(),e.getMessage());
    }
    
    
    /**
     * Controller层出现的方法参数校验异常
     *
     * @param e MethodArgumentNotValidException
     * @return 统一返回结果
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultDTO handleMethodException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> errMap = null;
        if (bindingResult.hasErrors()){
            errMap = bindingResult.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));
            log.error("参数校验异常:{}",errMap);
        }
        return ResultDTO.failed(ErrorCodeEnum.PARAMS_VALIDATE_ERROR,errMap);
    }
    
    
    /**
     * Service层出现的校验异常
     *
     * @param e 约束异常
     * @return 统一结果
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResultDTO handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violationSet = e.getConstraintViolations();
        
        Map<Path, String> errMap = null;
        if (violationSet.size() > 0) {
            errMap = violationSet.stream()
                             .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));
            log.error("ConstraintViolationException are:[{}]", errMap);
        }
        return ResultDTO.failed(ErrorCodeEnum.PARAMS_VALIDATE_ERROR,errMap);
    }
    
    /**
     * 未捕获异常处理
     * @param e Exception
     * @return 统一结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultDTO handleCustomizeException(Exception e){
        return ResultDTO.failed(e.getMessage());
    }
    
}
