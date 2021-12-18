package com.stackroute.tenantmatchmakingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TenantMatchmakingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenantMatchmakingServiceApplication.class, args);
	}

}
