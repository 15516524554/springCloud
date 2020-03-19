package com.cetc.springcloud.configbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced//默认轮询算法  访问消息提供者
   public RestTemplate restTemplate(){
       return new RestTemplate();
   }

    /**
     * 自定义  ribbon 均衡
     * @return
     */
   @Bean
   public IRule myRule(){
       //随机
        return new RandomRule();
        //轮询 return new RoundRobinRule();
       //
       //RetryRule()  会先按照轮询的策略获取服务  如果获取服务失败则在指定时间内重试，获取可用的服务

   }
}
