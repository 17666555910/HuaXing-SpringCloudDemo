package com.huaxing.rabbitmq._06springboot;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description SpringBoot 集成RabbitMQ --生产者
 * @author: 姚广星
 * @time: 2020/11/26 21:25
 */
@RestController
public class SendToSpringBootController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 简单的helloWord
     *
     * @param msg
     * @return
     */
    @RequestMapping("/queue")
    @ResponseBody
    public String sendMsg(String msg) {
        rabbitTemplate.convertAndSend("", "boot_queue", msg);
        return "发送成功";
    }

    /**
     * 手动签收实现方式发送端
     *
     * @param msg
     * @return
     */
    @RequestMapping("/sendBootQueueManuallySigned")
    @ResponseBody
    public String sendBootQueueManuallySigned(String msg) {
        rabbitTemplate.convertAndSend("", "boot_queue_ManuallySigned", msg);
        return "发送成功";
    }

    /**
     * work 模式发送端
     *
     * @param msg
     * @return
     */
    @RequestMapping("/sendBootQueueToWork")
    @ResponseBody
    public String sendBootQueueToWork(String msg) {
        for (int i = 0; i < 20; i++) {
            rabbitTemplate.convertAndSend("", "boot_queue_work", i + "：" + msg);
        }
        return "发送成功";
    }
}
