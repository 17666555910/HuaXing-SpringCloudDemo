package com.huaxing.rabbitmq._06springboot;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @author: 姚广星
 * @time: 2020/11/26 17:52
 */
@Slf4j
@Component
public class RecvToSpringBoot {

    @RabbitListener(queuesToDeclare = @Queue("boot_queue"))
    public void receiveMsg(String msg, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) {
        log.info("收到的消息-> deliveryTag:{}",deliveryTag);
        log.info("收到的消息-> channel:{}",channel.toString());
        log.info("收到的消息-> msg:{}",msg);
    }
}
