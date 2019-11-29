package com.demo.basic.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import java.util.Map;
import java.util.Set;

/**
 * List注解异常
 *
 * @author xielx at 2019/11/29 19:16
 */
public class ValidListException extends ValidationException {
    
   private Map<Integer,Set<ConstraintViolation<Object>>> errorMap;
   
    public ValidListException(Map<Integer,Set<ConstraintViolation<Object>>> map){
        this.errorMap = map;
    }
    
    public Map<Integer, Set<ConstraintViolation<Object>>> getErrorMap() {
        return errorMap;
    }
}
