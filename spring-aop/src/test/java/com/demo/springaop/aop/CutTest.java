package com.demo.springaop.aop;

import com.demo.springaop.config.AspectConfig;
import com.demo.springaop.service.IQuery;
import com.demo.springaop.service.QueryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 切入点测试
 *
 * @author xielx at 2020/1/27 21:03
 */
public class CutTest {
    
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(AspectConfig.class);
        ac.refresh();
        
        IQuery q = (IQuery) ac.getBean("qq");
        //QueryImpl q = (QueryImpl) ac.getBean("qq");
        q.query();
        ac.close();
    }
}
