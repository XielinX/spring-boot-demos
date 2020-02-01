package com.demo.springaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * 切面:1.声明为切面 2.交给spring管理,即为bean
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
    
    
    @Before("pointCutThis()")
    public void doBeforeWithThis() {
        log.info("**************aop before this*************");
    }
    
   // @Around("myPointCut()")
    public void doAround(ProceedingJoinPoint pjp) throws Throwable {
        log.info("**************aop around*************");
        // 获取参数
        Object[] args = pjp.getArgs();
        Object proceed = pjp.proceed();
        
    }
    
    
}
