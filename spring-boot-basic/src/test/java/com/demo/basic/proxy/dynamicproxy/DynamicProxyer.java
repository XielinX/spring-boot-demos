package com.demo.basic.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理,需要实现InvocationHandler接口
 *
 * @author xielx at 2020/2/1 16:14
 */
public class DynamicProxyer implements InvocationHandler {
    
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 目标对象
     */
    private Object target;
    
    public DynamicProxyer(String name, Object target) {
        this.name = name;
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy:" + proxy.getClass().getName());
        System.out.println("method:" + method.getName());
        Object invoke = method.invoke(target, args);
        return invoke;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Object getTarget() {
        return target;
    }
    
    public void setTarget(Object target) {
        this.target = target;
    }
}
