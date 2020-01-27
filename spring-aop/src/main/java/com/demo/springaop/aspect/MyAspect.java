package com.demo.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 声明一个切面
 *
 * @author xielx at 2020/1/27 20:37
 */

@Aspect
@Component
public class MyAspect {
    
    /**
     * 切点,在service包及子包的任何方法
     */
    @Pointcut("execution(public * com.demo.springaop.service..*.*(..))")
    public void myPointCut(){}
    
    /**
     * 前置通知
     */
    @Before("myPointCut()")
    public void printLoginLog(){
        System.out.println("aop---before********************");
    }
}
