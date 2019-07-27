package com.xlx.shiro.common.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

/**
 * shiro的密码加密
 *
 * @author xielx on 2019/7/22
 */
public class ShiroUtil {

	//private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	//@Value("${algorithmName}")
	private static final String algorithmName = "md5";
	//@Value("${hashIterations}")
	private static final Integer hashIterations = 2;


	/**
	 * 生成32位随机数
	 */
	public static String getHexRandomNumber(){
		return new SecureRandomNumberGenerator().nextBytes().toHex();
	}

	/**
	 * 密码加密
	 * @param pwd 明文
	 * @param credentialsSalt 盐(account + salt)
	 * @return 16进制编码存储密码
	 */
	public static String encryptPassword(String pwd,String credentialsSalt){
		SimpleHash simpleHash = new SimpleHash(algorithmName,pwd, ByteSource.Util.bytes(credentialsSalt),hashIterations);
		return simpleHash.toHex();
	}


	/**
	 * 获取Subject
	 * @return obj
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	public static void main(String[] args) {

		String num = getHexRandomNumber();
		System.out.println("随机数:" + num);//a7c8631308a0e7b59fd2cd78c083472b

		String en = encryptPassword("admin","admin" + num);
		//bcb0cf07c25cc0ff3a5677be4fd3d605
		System.out.println(en);
	}
}
