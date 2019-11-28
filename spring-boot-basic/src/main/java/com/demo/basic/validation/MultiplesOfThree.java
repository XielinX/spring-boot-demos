package com.demo.basic.validation;

import com.demo.basic.validation.validator.MultiplesOfThreeForList;
import com.demo.basic.validation.validator.MultiplesOfThreeForLong;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义注解类
 * 要求:
 *   Long 类型,数值为3的倍数
 *   List类型,元素个数为3的倍数
 * @author xielx at 2019/11/28 20:56
 */
@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {MultiplesOfThreeForLong.class, MultiplesOfThreeForList.class})
public @interface MultiplesOfThree {
    
    String message() default "必须是 3 的倍数";
    
    Class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default { };
}
