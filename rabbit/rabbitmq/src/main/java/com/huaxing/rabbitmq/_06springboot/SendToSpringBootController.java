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

    /**
     * 发布/订阅模式发送端
     *
     * @param msg
     * @return
     */
    @RequestMapping("/sendBootQueueToPubSub")
    @ResponseBody
    public String sendBootQueueToPubSub(String msg) {
        rabbitTemplate.convertAndSend("boot_queue_pub_sub", "", msg);
        return "发送成功";
    }

    /**
     * routing 模式生产者
     *
     * @param msg
     * @param routingKey    对应的routingKey
     * @return
     */
    @RequestMapping("/sendBootQueueToRouting")
    @ResponseBody
    public String sendBootQueueToRouting(String msg,String routingKey) {
        rabbitTemplate.convertAndSend("boot_queue_routing", routingKey, msg);
        return "发送成功";
    }

    /**
     * topics 模式生产者
     *
     * @param msg
     * @param routingKey    对应的routingKey
     * @return
     */
    @RequestMapping("/sendBootQueueToTopics")
    @ResponseBody
    public String sendBootQueueToTopics(String msg,String routingKey) {
        rabbitTemplate.convertAndSend("boot_queue_topics", routingKey, msg);
        return "发送成功";
    }
}
