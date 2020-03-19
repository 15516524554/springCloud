package com.cetc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //eureka服务注册中心  接受其他服务注册进来
public class MicroservicecloudEureka7001Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicecloudEureka7001Application.class, args);
	}

}
