package com.demo.basic.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xielx on 2019/7/24
 */
public class Person {

	
	private String name;
	private Integer age;
	/**
	 * 性别,1:男,2:女, 0:保密
	 */
	private Integer gender;
	private Date birth;
	private Map<String,Object> map;
	private List<String> list;
	private Dog dog;


}
