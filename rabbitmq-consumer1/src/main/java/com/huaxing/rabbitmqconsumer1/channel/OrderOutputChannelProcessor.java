package com.huaxing.rabbitmqconsumer1.channel;

import org.springframework.stereotype.Component;

/**
 * @Description 订单消息通道处理器
 * @author: 姚广星
 * @time: 2020/11/29 15:37
 */
@Component
public interface OrderOutputChannelProcessor {
    /**
     * 保存订单输出通道（需要与配置文件中的保持一致）
     */
    //String SAVE_ORDER_OUTPUT = "saveOrderOutput";
    /**
     * 订单输出通道（需要与配置文件中的保持一致）
     */
    //String ORDER_OUTPUT = "orderOutput";

    /**
     * 保存订单输出
     *
     * @return
     */
    //@Output(SAVE_ORDER_OUTPUT)
    //MessageChannel saveOrderOutput();

    /**
     * 订单输出
     *
     * @return
     */
    //@Output(ORDER_OUTPUT)
    //MessageChannel orderOutput();

}
