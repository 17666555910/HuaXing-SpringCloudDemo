package com.huaxing.rabbitmqconsumer1.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @Description 订单消息输入通道处理器
 * @author: 姚广星
 * @time: 2020/11/29 15:37
 */
@Component
public interface OrderInputChannelProcessor {
    /**
     * 保存订单输入通道（需要与配置文件中的保持一致）
     */
    String SAVE_ORDER_INPUT = "saveOrderInput";
    /**
     * 订单输入通道（需要与配置文件中的保持一致）
     */
    String ORDER_INPUT = "orderInput";

    /**
     * 保存订单输入方法
     *
     * @return
     */
    @Input(SAVE_ORDER_INPUT)
    SubscribableChannel saveOrderInput();

    /**
     * 订单输入方法
     *
     * @return
     */
    @Input(ORDER_INPUT)
    SubscribableChannel orderInput();

}
