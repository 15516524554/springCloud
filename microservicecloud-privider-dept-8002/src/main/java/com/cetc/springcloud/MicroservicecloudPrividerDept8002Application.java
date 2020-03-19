package com.cetc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroservicecloudPrividerDept8002Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicecloudPrividerDept8002Application.class, args);
	}

}
