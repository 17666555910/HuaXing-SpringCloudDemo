package com.huaxing.rabbitmq._03publish_subscribe;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * @Description Publish/Subscribe(发布/订阅) 模式消息发送者(生产者)。
 * @author: yaoguangxing
 * @time: 2020/11/22 21:58
 */
@Slf4j
public class SendToPublishSubscribe {
    private static String EXCHANGE_NAME = "pubSubExchange";

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
            //定义交换机 channel.exchangeDeclare("交换机名称", 交换机类型);
            channel.exchangeDeclare("pubSubExchange", BuiltinExchangeType.FANOUT);
            //定义消息内容
            String message = "Hello Word Huaxing elaborate on ! to date " + new Date();
            //通过通道往服务器中发送消息 channel.basicPublish("指定的交换机",发送的队列名称,消息的属性信息,字符串的byte数组);
            //MessageProperties.PERSISTENT_TEXT_PLAIN：消息是否持久化
            channel.basicPublish(EXCHANGE_NAME, "", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
            log.info("消息发送成功");
        }
    }
}
