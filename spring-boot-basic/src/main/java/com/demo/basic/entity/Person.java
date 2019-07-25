package com.demo.basic.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xielx on 2019/7/24
 */
@Component
//@ConfigurationProperties(prefix = "person")
public class Person {

	private String firstName;
	private Integer age;
	private Boolean female;//男
	private Date birth;
	private Map<String,Object> map;
	private List<String> list;
	private Dog dog;

	@Override
	public String toString() {
		return "Person{" +
									 "firstName='" + firstName + '\'' +
									 ", age=" + age +
									 ", female=" + female +
									 ", birth=" + birth +
									 ", map=" + map +
									 ", list=" + list +
									 ", dog=" + dog +
									 '}';
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getFemale() {
		return female;
	}

	public void setFemale(Boolean female) {
		this.female = female;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}
}
