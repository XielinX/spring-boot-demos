package com.demo.basic.validation.validator;

import com.demo.basic.validation.MultiplesOfThree;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author xielx at 2019/11/28 21:47
 */
public class MultiplesOfThreeForLong implements ConstraintValidator<MultiplesOfThree, Long> {
    
    @Override
    public void initialize(MultiplesOfThree constraintAnnotation) {
    
    }
    
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value % 3 == 0;
    }
}
