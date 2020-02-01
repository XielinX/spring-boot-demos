package com.demo.basic.proxy.staticproxy.entity;

import com.demo.basic.proxy.staticproxy.IAction;
/**
 * 追求者: 模拟静态代理的目标对象
 *
 * @author xielx at 2020/2/1 16:14
 */
public class Boy implements IAction {
    
    
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 追求的女孩
     */
    private Girl girl;
    
    @Override
    public void sendFlowers() {
        System.out.println(this.name + ":送" + girl.getName() + "999朵玫瑰!");
    }
    
    @Override
    public void sendChocolate() {
        System.out.println(this.name + ":送" + girl.getName() + "9盒巧克力!");
    }
    
    
    public Girl getGirl() {
        return girl;
    }
    
    public void setGirl(Girl girl) {
        this.girl = girl;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
}
