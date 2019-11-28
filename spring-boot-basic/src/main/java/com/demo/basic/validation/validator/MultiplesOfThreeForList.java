package com.demo.basic.validation.validator;

import com.demo.basic.validation.MultiplesOfThree;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * @author xielx at 2019/11/28 22:01
 */
public class MultiplesOfThreeForList implements ConstraintValidator<MultiplesOfThree, List> {
    @Override
    public void initialize(MultiplesOfThree constraintAnnotation) {
    
    }
    
    @Override
    public boolean isValid(List value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.size() % 3 == 0;
    }
}
