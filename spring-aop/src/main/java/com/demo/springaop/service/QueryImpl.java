package com.demo.springaop.service;

import org.springframework.stereotype.Component;

/**
 * 实现类
 *
 * @author xielx at 2020/1/27 21:01
 */
@Component("qq")
public class QueryImpl implements IQuery {
    
    
    
    @Override
    public void query() {
        System.out.println("query data from database~~~~~~~~~~~~~~");
    }
}
