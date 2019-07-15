package com.xlx.shiro.user;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * user测试
 *
 * @author xielx on 2019/7/14
 */
public class UserTest {


  @Test
  public void testBase64(){
     String str = "西红柿炒鸡蛋";
    String SECRET = Base64.encodeBase64String(str.getBytes());
    System.out.println("编码" + SECRET);
    System.out.println("解码:" + new String(Base64.decodeBase64(SECRET)));
    byte[] encodeKey = Base64.decodeBase64(SECRET);
    SecretKey secretKey = new SecretKeySpec(encodeKey,0,encodeKey.length,"AES");
    System.out.println("SecretKey:" + secretKey);

  }
}
