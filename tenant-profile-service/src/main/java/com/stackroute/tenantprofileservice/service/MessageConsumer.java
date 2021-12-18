//package com.stackroute.tenantprofileservice.service;
//
//import com.stackroute.tenantprofileservice.exception.TenantProfileAlreadyExistsException;
//import com.stackroute.tenantprofileservice.model.TenantProfile;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
//import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
///**
// * @Author Siva
// * @Date 11/18/2021 2:22 PM
// */
//@Component
//public class MessageConsumer implements RabbitListenerConfigurer {
//
//    private TenantProfileService tenantProfileService;
//    @Autowired
//    public MessageConsumer(TenantProfileService tenantProfileService) {
//        this.tenantProfileService = tenantProfileService;
//    }
//
//    private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
//
//    @Value("${spring.rabbitmq.exchange}")
//    private String exchange;
//
//    @Value("${spring.rabbitmq.routingkey}")
//    private String routingkey;
//
//    @RabbitListener(queues = "${spring.rabbitmq.queue}")
//    public void receiveMessageToRabbitMq(String email) throws TenantProfileAlreadyExistsException, IOException {
//        logger.info("Received TenantProfile:" + email);
//        TenantProfile tenantProfile = new TenantProfile();
//        tenantProfile.setEmail(email);
//        tenantProfileService.registerProfile(tenantProfile);
//    }
//
//    @Override
//    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar){
//
//    }
//
//}
