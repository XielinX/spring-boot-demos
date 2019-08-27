package com.example.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 发送
 * Send-->==队列===--->Receive
 *
 * try(资源){}:
 * jdk7的特性,try括号内的资源会在try语句结束后自动释放，前提是这些可关闭的资源必须实现 java.lang.AutoCloseable 接口。
 *
 * @author xielx on 2019/8/25
 */
public class Send {

	private final static String QUEUE_NAME = "hello";

	public static void main(String[] args) throws Exception{
		// 1. 创建到服务器的连接
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		//使用try-with-resources
		try (Connection connection = factory.newConnection();
				 // 2.创建一个通道
				 Channel channel = connection.createChannel()) {

			// 3.声明一个队列来发送
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "Hello World!";
			//4.发布
			channel.basicPublish("",QUEUE_NAME,null,message.getBytes("UTF-8"));
			System.out.println("[x] Sent:" + message);

		}
	}
}
