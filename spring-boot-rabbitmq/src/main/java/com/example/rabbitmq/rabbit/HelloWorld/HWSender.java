package com.example.rabbitmq.rabbit.HelloWorld;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 发送者
 * @author xielx on 2019/8/27
 */
@Component
public class HWSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(){
		String context = "hello world" + LocalDateTime.now();
		System.out.println("will send message is:" + context);
		this.amqpTemplate.convertAndSend("hello",context);
	}
}
