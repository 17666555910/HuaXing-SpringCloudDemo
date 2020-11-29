package com.huaxing.rabbitmqconsumer1;

import com.huaxing.rabbitmqconsumer1.channel.OrderInputChannelProcessor;
import com.huaxing.rabbitmqconsumer1.channel.OrderOutputChannelProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(value = {OrderInputChannelProcessor.class})
public class RabbitmqConsumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumer1Application.class, args);
    }
}
