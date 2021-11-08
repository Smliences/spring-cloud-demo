package com.sml.springcloudorderservice.controller;

import com.sml.springcloudconfig.lock.EnableLock;
import com.sml.springcloudorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sml
 * @Date 2021/11/8 上午11:41
 * @Description
 **/


@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("get")
    @EnableLock
    public String get(String key) {
        return orderService.get(key);
    }

    @PostMapping("set")
    public void set(String key,String value) {
         orderService.set(key,value);
    }

}
