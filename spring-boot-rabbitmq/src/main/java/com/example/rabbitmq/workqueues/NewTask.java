package com.example.rabbitmq.workqueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * 发送
 *
 * @author xielx on 2019/8/25
 */
public class NewTask {

	private static final String TASK_QUEUE_NAME = "task_queue";

	public static void main(String[] args) throws Exception{

		// 1.创建连接
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		try(Connection connection = factory.newConnection();
				// 2.创建频道
				Channel channel = connection.createChannel()){

			//3.声明队列:队列名,永久队列,限制队列,不使用时自动删除,队列其他构造参数
			channel.queueDeclare(TASK_QUEUE_NAME,true,false,false,null);
			String message = "hello...";

			//4.发布:交换的信息,routing key,其他消息属性,消息体
			channel.basicPublish("",TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + message + "'");
		}


	}
}
