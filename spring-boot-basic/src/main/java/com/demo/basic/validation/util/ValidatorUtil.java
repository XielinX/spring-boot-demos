package com.demo.basic.validation.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Validator;


/**
 * 工具类
 *
 * @author xielx at 2019/11/29 18:59
 */
@Component
public class ValidatorUtil {
    
    public static Validator validator;
    
    @Autowired
    public void setValidator(Validator validator) {
        ValidatorUtil.validator = validator;
    }
}
