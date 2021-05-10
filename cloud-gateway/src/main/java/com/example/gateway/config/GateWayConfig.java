package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //通过访问  localhost:9527/guonei  可以映射到http://news.baidu.com/guonei这个地址
        routes.route("path_route_jyn",
                r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
   /* @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //通过访问  localhost:9527/guoji  可以映射到http://news.baidu.com/guoji这个地址
        routes.route("path_route_jyn2",
                r->r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }*/
}
