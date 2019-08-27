package com.example.rabbitmq.workqueues;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 接收
 *
 * @author xielx on 2019/8/26
 */
public class Recv {

	private static final String TASK_QUEUE_NAME = "task_queue";

	private static void doTask(String task) throws InterruptedException {
		for (char c : task.toCharArray()){
			if (c == '.'){
				Thread.sleep(1000);
			}
		}
	}
	public static void main(String[] args) throws Exception {

		//
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();

		//
		Channel channel = connection.createChannel();
		//
		channel.queueDeclare(TASK_QUEUE_NAME,true,false,false,null);

		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		channel.basicQos(1);
		//
		DeliverCallback deliverCallback = new DeliverCallback() {
			@Override
			public void handle(String consumerTag, Delivery message) throws IOException {
				String msg = new String(message.getBody(),"UTF-8");
				System.out.println("接收信息:" + msg);

				try{
					doTask(msg);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println("完毕");
					channel.basicAck(message.getEnvelope().getDeliveryTag(),false);
				}

			}
		};




		//
		channel.basicConsume(TASK_QUEUE_NAME,false,deliverCallback,consumerTag -> {});
	}
}
