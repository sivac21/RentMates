package com.stackroute.propertyownerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class PropertyOwnerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyOwnerServiceApplication.class, args);




	}

}
