package com.example.rabbitmq.rabbit.HelloWorld;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收者
 *
 * @author xielx on 2019/8/27
 */
@Component
@RabbitListener(queues = "hello")
public class HWReceiver {


	@RabbitHandler
	public void process(String deliver){
		System.out.println("Receiver:" + deliver);
	}
}
