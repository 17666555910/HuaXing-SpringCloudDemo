package com.huaxing.rabbitmq._02_work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * @Description work 模式消息发送者(生产者)。
 * @author: yaoguangxing
 * @time: 2020/11/21 23:20
 */
@Slf4j
public class Send2 {
    /**
     * 队列名称
     */
    private static String QUEUE_NAME = "workQueue";

    /**
     * work 模式消息发送者(生产者)
     *
     */
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置rabbitmq地址和端口
        factory.setHost("localhost");
        //默认端口为 5672
        factory.setPort(45672);
        //创建连接和消息通道,try 中生成的连接会在finally关闭
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            //通过通道向服务器发送请求，声明一个队列
            //channel.queueDeclare(队列名称,队列是否需要持久化,是否排他性的队列,是否使用完队列之后删除队列,消息的属性信息);
            //队列是否需要持久化：配合MessageProperties.PERSISTENT_TEXT_PLAIN使用。
            //是否排他性的队列：排他性的队列只能给当前connection所创建出来的通道所使用，别的connection无法获取到这个消息。
            //消息的属性信息：可以自定义一些属性
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            //模拟发送30条短信
            for (int i = 0; i < 10; i++) {
                //定义消息内容
                String message = "第 " + i + " Hello Word Huaxing elaborate on ! to date " + new Date();
                //通过通道往服务器中发送消息 channel.basicPublish("指定的交换机",路由key,消息的属性信息,字符串的byte数组);
                //MessageProperties.PERSISTENT_TEXT_PLAIN：消息是否持久化
                channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
            }
            log.info("消息发送成功");
        }
    }
}
