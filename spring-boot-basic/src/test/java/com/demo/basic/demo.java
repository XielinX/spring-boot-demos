package com.demo.basic;

import org.junit.Test;



/**
 * 1年工作经验,从事系统数据维护方面;
 * Java自学
 * 有良好的责任意识，乐于助人;
 * 良好的团队合作精神,能承受一定的工作压力；
 * 平时注重团队精神，有一定的逻辑思维能力、沟通能力及 解决问题的能力.
 */
public class demo {

	@Test
	public void testBase64(){

		byte[] phone = java.util.Base64.getDecoder().decode("MTczNTA4NTI5Mjc=");
		System.out.println(new String(phone));
	}
}
