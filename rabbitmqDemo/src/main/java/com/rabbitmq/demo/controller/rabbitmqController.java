package com.rabbitmq.demo.controller;

import com.rabbitmq.demo.service.rabbitmqService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/rabbitmq")
public class rabbitmqController {

    @Resource
    private rabbitmqService rabbitmqService;

    @PostMapping("/sendMsg")
    public String sendMsg(@RequestParam(name="msg") String msg) throws Exception{
        return rabbitmqService.sendMsg(msg);

    }
}
