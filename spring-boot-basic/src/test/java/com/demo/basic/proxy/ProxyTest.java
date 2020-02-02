package com.demo.basic.proxy;
import com.demo.basic.proxy.dynamicproxy.DynamicProxyer;
import com.demo.basic.proxy.staticproxy.StaticProxyer;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author xielx at 2020/2/1 17:34
 */
public class ProxyTest {
    
    /**
     * 静态代理测试
     */
    @Test
    public void testStaticProxy() {
        Girl girl = new Girl("菲菲",18);
        
        Boy boy = new Boy();
        boy.setName("向明");
        boy.setAge(18);
        boy.setGirl(girl);
        
        StaticProxyer proxyer = new StaticProxyer("小王",boy);
        proxyer.sendChocolate();
        proxyer.sendFlowers();
    }
    
    /**
     * 动态代理测试
     */
    @Test
    public void testDynamicProxy() {
        Girl girl = new Girl("菲菲",18);
        
        Boy boy = new Boy();
        boy.setName("向明");
        boy.setAge(18);
        boy.setGirl(girl);
    
        DynamicProxyer proxyer = new DynamicProxyer("代理者",boy);
        IAction ia = (IAction) Proxy.newProxyInstance(boy.getClass().getClassLoader(), boy.getClass().getInterfaces(), proxyer);
        ia.sendChocolate();
        ia.sendFlowers();
    }
}
