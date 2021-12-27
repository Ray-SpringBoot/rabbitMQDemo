package com.rabbitmq.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class rabbitmqConfig {

    /**
     * RabbitMQ 隊列主題名稱
     */
    public static final String RABBITMQ_DEMO_TOPIC = "rabbitmqDemoTopic" ;
    /**
     * RabbitMQ DIRECT EXCHANGE名稱
     */
    public static final String RABBITMQ_DEMO_DIRECT_EXCHANGE = "rabbitmqDemoDirectExchange";
    /**
     * RabbitMQ DIRECT EXCHANGE和隊列綁定的匹配鍵 DirectRouting
     */
    public static final String RABBITMQ_DEMO_DIRECT_ROUTING = "rabbitmqDemoDirectRouting";

    @Bean
    public Queue rabbitDirectQueue(){
        /**
         * 1、name:    隊列名稱
         * 2、durable: 是否持久化
         * 3、exclusive: 是否獨享、排外的。如果設置為true，定義為排他隊列。只有創建者可以使用此隊列。也就是private私有的。
         * 4、autoDelete: 是否自動刪除。也就是臨時隊列。當最后一個消费者段開連結後，會自動刪除。
         * */
        return new Queue(rabbitmqConfig.RABBITMQ_DEMO_TOPIC,true,false,false);
    }

    @Bean
    public DirectExchange rabbitmqDemoDirectExchange() {
        //Direct 交換機
        return new DirectExchange(RABBITMQ_DEMO_DIRECT_EXCHANGE, true, false);
    }
    @Bean
    public Binding bindDirect() {
        //鍊式寫法，綁定交換機和隊列，並設置路由鍵
        return BindingBuilder
                //绑定隊列
                .bind(rabbitDirectQueue())
                //到交換機
                .to(rabbitmqDemoDirectExchange())
                //設置路由鍵
                .with(RABBITMQ_DEMO_DIRECT_ROUTING);
    }

}
