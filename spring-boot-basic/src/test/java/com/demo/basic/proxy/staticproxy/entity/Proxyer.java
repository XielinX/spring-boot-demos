package com.demo.basic.proxy.staticproxy.entity;

import com.demo.basic.proxy.staticproxy.IAction;

/**
 * 委托人: 男孩害羞,委托这个人去和女孩传信
 *
 * @author xielx at 2020/2/1 16:14
 */
public class Proxyer implements IAction {
    
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 目标对象
     */
    private  Boy boy;
    
    public Proxyer(String name, Boy boy) {
        this.name = name;
        this.boy = boy;
    }
    
    @Override
    public void sendFlowers() {
        this.boy.sendFlowers();
    }
    
    @Override
    public void sendChocolate() {
        this.boy.sendChocolate();
    }
    
    public Boy getBoy() {
        return boy;
    }
    
    public void setBoy(Boy boy) {
        this.boy = boy;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
