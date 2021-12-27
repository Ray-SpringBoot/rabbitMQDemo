package com.rabbitmq.demo.service.impl;

import com.rabbitmq.demo.config.rabbitmqConfig;
import com.rabbitmq.demo.service.rabbitmqService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class rabbitmqServiceImpl implements rabbitmqService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public String sendMsg(String msg) throws Exception {
        try {
            rabbitTemplate.convertAndSend(rabbitmqConfig.RABBITMQ_DEMO_DIRECT_EXCHANGE, rabbitmqConfig.RABBITMQ_DEMO_DIRECT_ROUTING, msg);
            System.out.println(msg);
            return msg;
        } catch (Exception e) {
            return "error";
        }
    }
}
