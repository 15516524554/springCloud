package com.cetc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class DeptPrividerHystrix8004_App {
  public static void main(String[] args) {
      SpringApplication.run(DeptPrividerHystrix8004_App.class, args);
  }
}
