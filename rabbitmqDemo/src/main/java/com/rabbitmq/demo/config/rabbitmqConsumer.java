package com.rabbitmq.demo.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = rabbitmqConfig.RABBITMQ_DEMO_TOPIC)
public class rabbitmqConsumer {

    @RabbitHandler
    public void process(String msg){
        System.out.println("消費消息"+msg);
    }
}
