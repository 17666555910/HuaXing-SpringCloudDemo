package com.huaxing.rabbitmq._06springboot;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
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
     * @RabbitListener：RabbitMQ 消息监听器
     */
    @RabbitListener(
            queuesToDeclare = @Queue("boot_queue")//使用默认的交换机 @Queue：队列消息配置
    )
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
    @RabbitListener(
            queuesToDeclare = @Queue("boot_queue_ManuallySigned")//使用默认的交换机 @Queue：队列消息配置
    )
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

    /**
     * work 模式消费者1
     *
     * @param msg         消息
     * @param deliveryTag 消息唯一标识
     * @param channel     通道
     * @throws IOException
     */
    @RabbitListener(
            queuesToDeclare = @Queue("boot_queue_work")//使用默认的交换机 @Queue：队列消息配置
    )
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

    /**
     * work 模式消费者2
     *
     * @param msg         消息
     * @param deliveryTag 消息唯一标识
     * @param channel     通道
     * @throws IOException
     */
    @RabbitListener(
            queuesToDeclare = @Queue("boot_queue_work")//使用默认的交换机 @Queue：队列消息配置
    )
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

    /**
     * 发布/订阅模式接收者01
     *
     * @param msg
     * @param deliveryTag
     * @param channel
     * @throws IOException
     */
    @RabbitListener(//RabbitMQ 监听器
            bindings = @QueueBinding(//创建队列和交换机的绑定关系
                    value = @Queue(),//创建个匿名队列
                    exchange = @Exchange(name = "boot_queue_pub_sub", type = "fanout")//定义交换机，指定交换机名称和类型
            )
    )
    public void receiveMsgToPubSub1(String msg,
                                    @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, //@Header 获取消息体header中的信息
                                    Channel channel) throws IOException {
        try {
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

    /**
     * 发布/订阅模式接收者02
     *
     * @param msg
     * @param deliveryTag
     * @param channel
     * @throws IOException
     */
    @RabbitListener(//RabbitMQ 监听器
            bindings = @QueueBinding(//创建队列和交换机的绑定关系
                    value = @Queue(),//创建个匿名队列
                    exchange = @Exchange(name = "boot_queue_pub_sub", type = "fanout")//定义交换机，指定交换机名称和类型
            )
    )
    public void receiveMsgToPubSub2(String msg,
                                    @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, //@Header 获取消息体header中的信息
                                    Channel channel) throws IOException {
        try {
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

    /**
     * routing 模式消费者01
     *
     * @param msg
     * @param deliveryTag
     * @param channel
     * @throws IOException
     */
    @RabbitListener(//RabbitMQ 监听器
            bindings = @QueueBinding(//创建队列和交换机的绑定关系
                    value = @Queue(),//创建个匿名队列
                    exchange = @Exchange(name = "boot_queue_routing", type = "direct"),//定义交换机，指定交换机名称和类型
                    key = {"log.error", "log.info", "log.warning"}//定义routingKey
            )
    )
    public void receiveMsgToRouting01(String msg,
                                      @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, //@Header 获取消息体header中的信息
                                      Channel channel) throws IOException {
        try {
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

    /**
     * routing 模式消费者02
     *
     * @param msg
     * @param deliveryTag
     * @param channel
     * @throws IOException
     */
    @RabbitListener(//RabbitMQ 监听器
            bindings = @QueueBinding(//创建队列和交换机的绑定关系
                    value = @Queue(),//创建个匿名队列
                    exchange = @Exchange(name = "boot_queue_routing", type = "direct"),//定义交换机，指定交换机名称和类型
                    key = {"log.error"}//定义routingKey
            )
    )
    public void receiveMsgToRouting02(String msg,
                                      @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, //@Header 获取消息体header中的信息
                                      Channel channel) throws IOException {
        try {
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
