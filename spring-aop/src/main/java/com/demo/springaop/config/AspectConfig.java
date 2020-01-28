package com.demo.springaop.config;

import com.demo.springaop.service.IQuery;
import com.demo.springaop.service.QueryImpl;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AspectJ配置类
 *
 * @author xielx at 2020/1/27 20:38
 */
@ComponentScan("com.demo.springaop")
@EnableAspectJAutoProxy
public class AspectConfig {


    /*@Bean("qq")
    public IQuery queryImpl(){
        return new QueryImpl();
    }*/
}
