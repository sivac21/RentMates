package com.stackroute.userservice.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author Siva
 * @Date 10/29/2021 1:02 PM
 */
@Service
public class UserMessageProducer {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public UserMessageProducer(RabbitTemplate rabbitTemplate) {
        super();
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    public void sendMessageToRabbitMq(String email)
    {
        System.out.println("In producer method:"+email);
        rabbitTemplate.convertAndSend(exchange,routingkey, email);
    }
}
