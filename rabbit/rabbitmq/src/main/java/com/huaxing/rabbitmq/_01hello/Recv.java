package com.huaxing.rabbitmq._01hello;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * @Description 消息接收者（消费者）
 * @author: yaoguangxing
 * @time: 2020/11/16 22:31
 */
@Slf4j
public class Recv {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        //简单的hello word 案例
        //helloWord();
        //签收机制的实现 案例
        //signForTest();
    }

    /**
     * 简单的hello word 案例
     *
     * @throws IOException
     * @throws TimeoutException
     */
    private static void helloWord() throws IOException, TimeoutException {
        //定义消息工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置端口和ip
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(45672);
        //创建连接
        Connection connection = connectionFactory.newConnection();
        //创建消息通道
        Channel channel = connection.createChannel();
        //如果队列在服务其中存在，则不创建，如果已经在队列中存在，就要确保该队列的参数和生产者的参数是一致的，不然会报错
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        /*  函数编程的写法，等价于
            new DeliverCallback() {
                @Override
                public void handle(String s, Delivery delivery) throws IOException {
                }
            };
        */
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            //consumerTag 消费者的标识
            //delivery 消息对象，类似余htpp协议的对象；delivery.getBody() 具体的消息
            String message = new String(delivery.getBody(),"UTF-8");
            log.info("consume queue message={}, to date={}",message,new Date());
        };
        //通过通道定义消费的监听对象 channel.basicConsume(需要监听队列名称,true,消息的监听事件处理器,消息队列删除的时候会触发这个方法);
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,consumerTag ->{});
    }

    /**
     * 签收机制的实现方式
     *
     * @throws IOException
     */
    private static void signForTest() throws IOException, TimeoutException {
        //定义消息工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置端口和ip
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(45672);
        //创建连接
        Connection connection = connectionFactory.newConnection();
        //创建消息通道
        Channel channel = connection.createChannel();
        //如果队列在服务其中存在，则不创建，如果已经在队列中存在，就要确保该队列的参数和生产者的参数是一致的，不然会报错
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        /*  函数编程的写法，等价于
            new DeliverCallback() {
                @Override
                public void handle(String s, Delivery delivery) throws IOException {
                }
            };
        */
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            //consumerTag 消费者的标识
            //delivery 消息对象，类似余htpp协议的对象；delivery.getBody() 具体的消息
            String message = new String(delivery.getBody(), "UTF-8");
            try {
                //具体的业务处理 TODO
                log.info("consume queue message={}, to date={}", message, new Date());

                //消息签收
                //channel.basicAck(消息唯一标识，是否批量签收);
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            } catch (UnsupportedEncodingException e) {
                //消息异常时处理机制
                //channel.basicReject();//老版本的消息异常处理机制；
                //channel.basicNack(deliveryTag:消息的唯一标识,multiple:是否批量处理,requeue:是否重新放入队列);
                //当requeue 为true时，需要自己控制重试次数，不然会造成死循环。这时需要把代码做如下处理；

/*              String id = "";//从消息中获取具体业务的唯一标识
                int count = redis.incr("前缀" + id);//调用redis.incr("前缀"+id); 控制重试次数
                if (count > 5) {
                    channel.basicNack(delivery.getEnvelope().getDeliveryTag(), false, false);
                } else {
                    channel.basicNack(delivery.getEnvelope().getDeliveryTag(), false, true);
                }*/
            }
        };
        //通过通道定义消费的监听对象 channel.basicConsume(需要监听队列名称,是否自动签收消息,消息的监听事件处理器,消息队列删除的时候会触发这个方法);
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> {
        });
    }
}
