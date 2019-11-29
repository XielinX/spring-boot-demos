package com.demo.basic.validation;

import com.demo.basic.exception.ValidListException;
import com.demo.basic.validation.validator.ValidListForList;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * List校验注解
 *
 * @author xielx at 2019/11/29 18:47
 */
@Target({FIELD,PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ValidListForList.class})
public @interface ValidList {
    
    // 自定义分组
    Class<?>[] grouping() default { };
    
    // 快速失败:有一个错误,后面都不会去校验
    boolean quickFail() default false;
    
    String message() default "";
    
    Class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default { };
}
