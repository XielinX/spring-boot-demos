package com.example.rabbitmq.helloworld;

import com.rabbitmq.client.*;

/**
 * 消息接收
 *
 * @author xielx on 2019/8/25
 */
public class Recv {

	private static final String QUEUE_NAME = "hello";

	public static void main(String[] args) throws Exception {
		// 1.创建一个连接
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		Connection connection = factory.newConnection();

		// 2. 创建一个通道
		Channel channel = connection.createChannel();
		// 3.声明队列(发送方的)
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");


		/*DeliverCallback deliver = new DeliverCallback() {
			@Override
			public void handle(String s, Delivery delivery) throws IOException {
				//
			}
		};*/

		// 4.接收消息
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			System.out.println("[X] Received:" + message);
		};

		//
		channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
		});
	}
}
