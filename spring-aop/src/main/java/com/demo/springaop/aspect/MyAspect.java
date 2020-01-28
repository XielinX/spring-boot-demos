package com.demo.springaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
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
@Slf4j
public class MyAspect {
    
    
    /**
     * execution: 指定表达式,执行
     */
    @Pointcut("execution(* com.demo.springaop.service..*.*(..))")
    public void myPointCut() {
    }
    
    /**
     * within:在类中,执行
     */
    @Pointcut("within(com.demo.springaop.service.*)")
    public void myWithIn() {
    }
    
    /**
     * args:只有一个参数的,执行
     */
    @Pointcut("args(java.lang.String)")
    public void myArgs() {
    }
    
    /**
     * this:属于指定类,执行
     */
    @Pointcut("this(com.demo.springaop.service.QueryImpl)")
    public void pointCutThis() {
    }
    
    /**
     *
     */
    @Pointcut("target(com.demo.springaop.service.QueryImpl)")
    public void pointCutTarget() {
    }
    
    
    /**
     * 前置通知
     */
    //@Before("myPointCut() && !myArgs()")
    public void doBeforeWithExecution() {
        log.info("**************aop before*************");
    }
    
    
    @Before("pointCutTarget()")
    public void doBeforeWithThis() {
        log.info("**************aop before this*************");
    }
    
}
