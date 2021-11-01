package com.sml.springcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayApplication.class, args);
    }

    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes().
                route("hello_route",j -> j.path("/baidu/**").uri("http://www.baidu.com"))
                .build();
    }
}
