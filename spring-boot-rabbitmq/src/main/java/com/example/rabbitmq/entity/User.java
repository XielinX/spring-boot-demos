package com.example.rabbitmq.entity;

import java.io.Serializable;

/**
 * 用户
 *
 * @author xielx on 2019/8/27
 */
public class User implements Serializable {

	private Integer id;

	private String userName;

	private String password;

	@Override
	public String toString() {
		return "User{" +
									 "id=" + id +
									 ", userName='" + userName + '\'' +
									 ", password='" + password + '\'' +
									 '}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
