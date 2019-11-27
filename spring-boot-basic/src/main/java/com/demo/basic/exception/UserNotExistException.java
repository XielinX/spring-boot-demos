package com.demo.basic.exception;

/**
 * 用户异常
 *
 * @author xielx on 2019/7/30
 */
public class UserNotExistException extends RuntimeException {


	public UserNotExistException(String message){
		super(message);
	}
	
}
