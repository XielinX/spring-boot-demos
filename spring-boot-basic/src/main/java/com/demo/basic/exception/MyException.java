package com.demo.basic.exception;

import lombok.Data;

/**
 * 用户异常
 *
 * @author xielx on 2019/7/30
 */
@Data
public class MyException extends RuntimeException {

	private Integer code;

	private String message;


	public MyException(){
		super();
	}

	public MyException(Integer code){
		code = this.code;
	}

	public MyException(String message){
		this.message = message;
	}

	public MyException(Integer code,String message){
		this.code = code;
	  this.message = message;
	}

	public MyException(String message,Throwable t){
		super(message,t);
	}

}
