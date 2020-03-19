package com.cetc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MicroserviceConsumerHystrixDashboard_App {
  public static void main(String[] args) {
      SpringApplication.run(MicroserviceConsumerHystrixDashboard_App.class, args);
  }
}
