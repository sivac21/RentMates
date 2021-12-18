package com.stackroute.tenantprofileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class TenantProfileServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(TenantProfileServiceApplication.class, args);
	}


//	@Value("${spring.rabbitmq.host}")
//	String host;

//	@Value("${spring.rabbitmq.username}")
//	String username;
//	@Value("${spring.rabbitmq.password}")
//	String password;

//	@Bean
//	CachingConnectionFactory cachingConnectionFactory(){
//		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
//		cachingConnectionFactory.setUsername(username);
//		cachingConnectionFactory.setPassword(password);
//		return cachingConnectionFactory;
//	}


//	public MessageConverter jsonMessageConvertor(){
//		return new Jackson2JsonMessageConverter();
//	}

//	@Bean
//	public RabbitTemplate rabbitTemplates (ConnectionFactory connectionFactory){

//
//		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//		rabbitTemplate.setMessageConverter(jsonMessageConvertor());
//		return rabbitTemplate;
//	}

}
