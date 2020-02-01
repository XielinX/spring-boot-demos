package com.demo.basic.proxy.staticproxy;
import com.demo.basic.proxy.staticproxy.entity.Boy;
import com.demo.basic.proxy.staticproxy.entity.Girl;
import com.demo.basic.proxy.staticproxy.entity.Proxyer;
import org.junit.Test;

/**
 * 静态代理测试
 *
 * @author xielx at 2020/2/1 17:34
 */
public class ProxyTest {
    
    
    @Test
    public void testStaticProxy() {
        Girl girl = new Girl("菲菲",18);
        
        Boy boy = new Boy();
        boy.setName("向明");
        boy.setAge(18);
        boy.setGirl(girl);
        
        Proxyer proxyer = new Proxyer("小王",boy);
        proxyer.sendChocolate();
        proxyer.sendFlowers();
    }
}
