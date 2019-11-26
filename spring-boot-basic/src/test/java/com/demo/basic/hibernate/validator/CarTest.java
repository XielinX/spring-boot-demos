package com.demo.basic.hibernate.validator;


import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 参数校验测试
 *
 * @author xielx at 2019/11/26 14:04
 */
public class CarTest {

    private  Validator validator;
    
    
    /**
     * 工厂构建实例
     */
    @Before
    public  void setUpValidator(){
        // 获取validator实例
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    
    @Test
    public void manufacturerIsNull(){
        // 构建验证对象
        Car car = new Car(null,"DD-AB-123",4);
    
        // 验证成功,返回的集合是空的,错误的会加入到集合里
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        
        List<String> msgList = constraintViolations.stream().map(v -> v.getPropertyPath() + "|" + v.getMessage() + "|" + v.getInvalidValue()).collect(Collectors.toList());
        msgList.forEach(System.out::println);
        
    }
    
    @Test
    public void licensePlateTooShort() {
        Car car = new Car("Morris", "D", 1);
        Set<ConstraintViolation<Car>> violations = validator.validateProperty(car, "licensePlate");
        System.out.println(violations);
    }
    
    @Test
    public void methodOfValidateValue() {
        Car car = new Car("Morris", "D", 1);
        Set<ConstraintViolation<Car>> violations = validator.validateValue(Car.class,"licensePlate","A");
        System.out.println(violations.iterator().next().getMessage());
    }
    
}
