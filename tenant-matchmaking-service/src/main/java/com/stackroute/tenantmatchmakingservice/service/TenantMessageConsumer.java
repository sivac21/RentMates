//package com.stackroute.tenantmatchmakingservice.service;
//
//
//import com.stackroute.tenantmatchmakingservice.model.TenantProfile;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
//import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class TenantMessageConsumer implements RabbitListenerConfigurer {
//
//
//    private static final Logger logger = LoggerFactory.getLogger(TenantMessageConsumer.class);
//
//    @Value("${spring.rabbitmq.exchange}")
//    private String exchange;
//
//    @Value("${spring.rabbitmq.routingkeytenant}")
//    private String routingkeytenant;
//
//  @RabbitListener(queues = "${spring.rabbitmq.queuetenant}")
//    public void receiveMessageToRabbitMq(String tenantProfile) {
//      logger.info("Received TenantProfile"+tenantProfile);
//  }
//
//
//  @Override
//    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar){
//
//  }
//
//}
