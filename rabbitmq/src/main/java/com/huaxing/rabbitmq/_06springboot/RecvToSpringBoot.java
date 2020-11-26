package com.huaxing.rabbitmq._06springboot;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @author: 姚广星
 * @time: 2020/11/26 21:52
 */
@Slf4j
@Component
public class RecvToSpringBoot {

    /**
     * 简单消息的接收
     *
     * @param msg
     */
    @RabbitListener(queuesToDeclare = @Queue("boot_queue"))
    public void receiveMsg(String msg) {
        log.info("收到的消息-> msg:{}", msg);
    }

    /**
     * 手动签收接受者
     *
     * @param msg         消息
     * @param deliveryTag 消息唯一标识
     * @param channel     通道
     * @throws IOException
     */
    @RabbitListener(queuesToDeclare = @Queue("boot_queue_ManuallySigned"))
    public void receiveMsgToManuallySigned(String msg, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        try {
            //模拟出现异常
            //int a = 1 / 0;
            log.info("收到的消息-> msg:{}", msg);
            log.info("收到的消息标识-> deliveryTag:{}", deliveryTag);
            log.info("收到的消息-> channel:{}", channel.toString());
            //手动签收  channel.basicAck(消息唯一标识,是否批量签收);
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            e.printStackTrace();
            //channel.basicNack(deliveryTag:消息的唯一标识,multiple:是否批量处理,requeue:是否重新放入队列);
            //消息出现异常时，若requeue=false，则该消息会被放入死信队列，若没有配置死信队列则该消息会丢失。
            channel.basicNack(deliveryTag, false, false);
        }
    }

    @RabbitListener(queuesToDeclare = @Queue("boot_queue_work"))
    public void receiveMsgToToWork(String msg, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        try {
            //模拟服务器性能
            TimeUnit.SECONDS.sleep(1);
            log.info("01 消费者收到的消息 -> msg:{}", msg);
            //手动签收  channel.basicAck(消息唯一标识,是否批量签收);
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            e.printStackTrace();
            //channel.basicNack(deliveryTag:消息的唯一标识,multiple:是否批量处理,requeue:是否重新放入队列);
            //消息出现异常时，若requeue=false，则该消息会被放入死信队列，若没有配置死信队列则该消息会丢失。
            channel.basicNack(deliveryTag, false, false);
        }
    }
    @RabbitListener(queuesToDeclare = @Queue("boot_queue_work"))
    public void receiveMsgToToWork2(String msg, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        try {
            //模拟服务器性能
            TimeUnit.SECONDS.sleep(2);
            log.info("02 消费者收到的消息 -> msg:{}", msg);
            //手动签收  channel.basicAck(消息唯一标识,是否批量签收);
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            e.printStackTrace();
            //channel.basicNack(deliveryTag:消息的唯一标识,multiple:是否批量处理,requeue:是否重新放入队列);
            //消息出现异常时，若requeue=false，则该消息会被放入死信队列，若没有配置死信队列则该消息会丢失。
            channel.basicNack(deliveryTag, false, false);
        }
    }
}
