package com.demo.basic.validation.validator;

import com.demo.basic.exception.ValidListException;
import com.demo.basic.validation.ValidList;
import com.demo.basic.validation.util.ValidatorUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xielx at 2019/11/29 18:52
 */
public class ValidListForList implements ConstraintValidator<ValidList, List> {
    
    private Class<?>[] grouping;
    private boolean quickFail;
    
    @Override
    public void initialize(ValidList constraintAnnotation) {
        grouping = constraintAnnotation.grouping();
        quickFail = constraintAnnotation.quickFail();
    }
    
    /**
     * 循环校验集合元素,出现错误立即抛出异常
     * @param value 待校验集合
     * @param context ?
     * @return 校验成功,返回true
     */
    @Override
    public boolean isValid(List value, ConstraintValidatorContext context) {
        Map<Integer,Set<ConstraintViolation<Object>>> errors = new HashMap<>();
        for (int i = 0; i < value.size(); i++) {
            Object object = value.get(i);
            Set<ConstraintViolation<Object>> violationSet = ValidatorUtil.validator.validate(object,grouping);
            if (violationSet.size() > 0){
                errors.put(i,violationSet);
                if (quickFail){
                    throw new ValidListException(errors);
                }
            }
        }
        
        if (errors.size() > 0){
            throw new ValidListException(errors);
        }
        return true;
    }
    
}
