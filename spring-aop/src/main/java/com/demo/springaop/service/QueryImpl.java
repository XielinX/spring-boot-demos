package com.demo.springaop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 实现类
 *
 * @author xielx at 2020/1/27 21:01
 */
@Slf4j
@Component("qq")
public class QueryImpl implements IQuery {
    
    
    
    @Override
    public void query() {
        log.info("query**********");
    }
    
    @Override
    public void query1(String s1) {
        log.info("query1**********");
    }
    
    @Override
    public void query2(String s1, String s2) {
        log.info("query2**********");
    }
}
