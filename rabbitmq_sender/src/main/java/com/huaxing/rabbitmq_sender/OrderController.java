package com.huaxing.rabbitmq_sender;


import com.huaxing.rabbitmq_sender.channel.OrderOutputChannelProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Description 订单控制器
 * @author: 姚广星
 * @time: 2020/11/29 12:03
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderMessageProducer orderMessageProducer;

    /**
     * 发送保存订单消息
     *
     * @param message
     */
    @GetMapping(value = "/sendSaveOrderMessage")
    public void sendSaveOrderMessage(@RequestParam("message") String message) {
        //发送消息
        orderMessageProducer.sendMsg(message);
        log.info("发送保存订单消息成功");
    }

    /**
     * 发送保存订单消息-->实体对象方式
     *
     */
    @GetMapping(value = "/sendSaveOrderMessage2")
    public void sendSaveOrderMessage2() {
        Order order = new Order();
        order.setId("1");
        order.setOrderNo("[2020]110000001");
        order.setProductId("123");
        order.setProductName("鼠标");
        order.setNumber(1);
        order.setPrice(new BigDecimal(100));
        //发送消息
        orderMessageProducer.sendMsg(order);
        log.info("发送保存订单消息成功");
    }
}
