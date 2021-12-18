//package com.stackroute.tenantprofileservice.service;
//import com.stackroute.tenantprofileservice.model.TenantProfile;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//
///**
// * @Author Rohit
// * @Date 02-Dec-21 3:05 PM
// */
//
//@Component
//public class TenantMessageProducer {
//    private RabbitTemplate rabbitTemplate;
//
//
//
//
//    @Autowired
//    public TenantMessageProducer(RabbitTemplate rabbitTemplate) {
//        super();
//        this.rabbitTemplate = rabbitTemplate;
//    }
//    @Value("${spring.rabbitmq.exchange}")
//    private String exchange;
//
//    @Value("${spring.rabbitmq.routingkey}")
//    private String routingkey;
//
//    @Value("${spring.rabbitmq.routingkeytenant}")
//    private String routingkeytenant;
//
//
//    public void sendMessageToRabbitMq(String tenantProfile)
//    {
//        System.out.println("In producer method:"+tenantProfile);
//        rabbitTemplate.convertAndSend(exchange,routingkeytenant, tenantProfile);
//    }
//}
//
//
