package com.example.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * RabbitMq配置
 *
 * @author xielx on 2019/8/25
 */
//@Configuration
public class RabbitMqConfig {


	//@Bean
	public Queue queue(){
		return  new Queue("hello");
	}
}
