package com.huaxing.rabbitmq_sender;

import com.huaxing.rabbitmq_sender.channel.OrderOutputChannelProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(value = {OrderOutputChannelProcessor.class})
public class RabbitmqSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqSenderApplication.class, args);
    }
}
