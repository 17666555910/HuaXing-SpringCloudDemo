package com.huaxing.rabbitmq._06springboot;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description SpringBoot 集成RabbitMQ --生产者
 * @author: 姚广星
 * @time: 2020/11/26 17:25
 */
@RestController
public class SendToSpringBootController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/queue")
    @ResponseBody
    public String sendMsg(String msg){
        rabbitTemplate.convertAndSend("","boot_queue",msg);
        return "发送成功";
    }
}
