package com.sml.springcloudorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringCloudOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOrderServiceApplication.class, args);
    }

    @RequestMapping("order/get")
    public String get() {
        return "order/test";
    }


}
