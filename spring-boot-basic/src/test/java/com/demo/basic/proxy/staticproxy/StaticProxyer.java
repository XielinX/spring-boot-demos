package com.demo.basic.proxy.staticproxy;

import com.demo.basic.proxy.Boy;
import com.demo.basic.proxy.IAction;

/**
 * 委托人: 男孩害羞,委托这个人去和女孩传信
 *
 * @author xielx at 2020/2/1 16:14
 */
public class StaticProxyer implements IAction {
    
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 目标对象
     */
    private  Boy boy;
    
    public StaticProxyer(String name, Boy boy) {
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
