package com.example.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GateWayFilterConfig implements GlobalFilter, Ordered {
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    System.out.println("***********come in全局自定义过滤器*******");
   String  name= exchange.getRequest().getQueryParams().getFirst("uname");
   if(name==null){
      System.err.println("用户名非法");
      exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
      return exchange.getResponse().setComplete();
   }
    return chain.filter(exchange);
  }

  @Override
  public int getOrder() {
    return 0;
  }
}
