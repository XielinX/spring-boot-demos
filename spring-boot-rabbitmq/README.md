# RabbitMQ
## 简介
## 概念

`AMQP`:即Advanced Message Queuing Protocol,高级消息队列协议，是应用层协议的一个开放标准，为面向消息的中间件设计

## 4种Exchange交换机模式
1. Direct Exchange
  + 直接模式:一对一完全匹配，需要将一个队列绑定到交换机上，要求该消息与一个特定的路由键完全匹配
2. Fanout Exchange
  + 广播模式:一对多完全匹配,你只需要简单的将队列绑定到交换机上。一个发送到交换机的消息都会被转发到与该交换机绑定的所有队列上,人手一份
3. Topic Exchange
  + 匹配模式: 多对多正则匹配。此时队列需要绑定要一个模式上
  + `#`:代替0个或多个单词
  + `*`:代替1个单词
4.  headers Exchange
  + headers交换器允许你匹配AMQP消息的header而非路由键除此之外
  + headers交换器和direct交换器完全一致，但性能会差很多。因此它并不太实用，而且几乎再也用不到了。 