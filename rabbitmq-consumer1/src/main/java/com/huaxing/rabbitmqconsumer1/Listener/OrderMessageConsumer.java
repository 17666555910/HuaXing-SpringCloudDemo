package com.huaxing.rabbitmqconsumer1.Listener;

import com.huaxing.rabbitmqconsumer1.channel.OrderInputChannelProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * @Description 订单消息接收处理服务
 * @author: 姚广星
 * @time: 2020/11/29 16:03
 */
@Slf4j
@EnableBinding(OrderInputChannelProcessor.class)
public class OrderMessageConsumer {

    /**
     * 保存订单逻辑
     * 通过OrderChannelProcessor.SAVE_ORDER接收消息
     * 然后通过SendTo 将处理后的消息发送到 OrderChannelProcessor.ORDER
     *
     * @param message
     * @return
     */
    @StreamListener(OrderInputChannelProcessor.SAVE_ORDER_INPUT)
    //@SendTo(OrderOutputChannelProcessor.ORDER_OUTPUT)
    public void saveOrderMessage(Message<String> message) {
        log.info("保存订单的消息：" + message);
        //处理之后的订单消息
        //return "【" + message.getPayload() + "】";
    }

    /**
     * 监听OrderChannelProcessor.ORDER通道，进行发送短信业务操作
     * @param message
     */
//    @StreamListener(OrderInputChannelProcessor.ORDER_INPUT)
//    public void orderToSMSMessage(String message) {
//        log.info("进行发送短信业务操作：{}",message);
//    }
//
//    /**
//     * 监听OrderChannelProcessor.ORDER通道，进行存储到es业务操作
//     * @param message
//     */
//    @StreamListener(OrderInputChannelProcessor.ORDER_INPUT)
//    public void orderToEsMessage(String message) {
//        log.info("进行存储到es业务操作：{}",message);
//    }
}
