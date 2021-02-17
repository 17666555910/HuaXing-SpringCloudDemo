package com.huaxing.rabbitmq._05topics;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Description Topics 消息接收者（消费者）
 * @author: yaoguangxing
 * @time: 2020/11/22 21:58
 */
@Slf4j
public class RecvToTopics1 {
    private static String EXCHANGE_NAME = "TopicsExchange";
    public static void main(String[] args) throws Exception {
        //定义消息工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置端口和ip
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(45672);
        //创建连接
        Connection connection = connectionFactory.newConnection();
        //创建消息通道
        Channel channel = connection.createChannel();
        //设置预读的数量，默认是读取250个
        channel.basicQos(1);
        //声明交换机   channel.exchangeDeclare(交换机名称, 交换机类型);
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        //定义队列的名称   channel.queueDeclare().getQueue();匿名的队列（随机的队列名称）:匿名队列结束之后自动删除。
        String queueName = channel.queueDeclare().getQueue();
        //声明队列和交换机的绑定关系
        channel.queueBind(queueName,EXCHANGE_NAME, "topic.error");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            try {
                //consumerTag 消费者的标识
                //delivery 消息对象，类似余htpp协议的对象；delivery.getBody() 具体的消息
                String message = new String(delivery.getBody(),"UTF-8");
                log.info("consume queue message={}, to date={}",message,new Date());
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
            } catch (Exception e) {
                e.printStackTrace();
                channel.basicNack(delivery.getEnvelope().getDeliveryTag(),false,false);
            }
        };
        //通过通道定义消费的监听对象 channel.basicConsume(需要监听队列名称,是否自动签收消息,消息的监听事件处理器,消息队列删除的时候会触发这个方法);
        channel.basicConsume(queueName,false,deliverCallback,consumerTag ->{});
    }
}
