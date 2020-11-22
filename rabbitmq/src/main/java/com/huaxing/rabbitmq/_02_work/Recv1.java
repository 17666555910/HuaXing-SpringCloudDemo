package com.huaxing.rabbitmq._02_work;

import ch.qos.logback.core.util.TimeUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Description work消息接收者（消费者）
 * @author: yaoguangxing
 * @time: 2020/11/16 22:31
 */
@Slf4j
public class Recv1 {
    private static final String QUEUE_NAME = "workQueue";

    /**
     * work消息接收者1（消费者）
     */
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
            try {
                //模拟服务器性能不同
                TimeUnit.SECONDS.sleep(1);
                //consumerTag 消费者的标识
                //delivery 消息对象，类似余htpp协议的对象；delivery.getBody() 具体的消息
                String message = new String(delivery.getBody(),"UTF-8");
                log.info("consume queue message={}, to date={}",message,new Date());
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
            } catch (InterruptedException e) {
                e.printStackTrace();
                channel.basicNack(delivery.getEnvelope().getDeliveryTag(),false,false);
            }
        };
        //通过通道定义消费的监听对象 channel.basicConsume(需要监听队列名称,是否自动签收消息,消息的监听事件处理器,消息队列删除的时候会触发这个方法);
        channel.basicConsume(QUEUE_NAME,false,deliverCallback,consumerTag ->{});
    }
}
