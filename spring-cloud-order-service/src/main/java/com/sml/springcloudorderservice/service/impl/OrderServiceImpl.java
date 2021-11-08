package com.sml.springcloudorderservice.service.impl;

import com.sml.springcloudorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author sml
 * @Date 2021/11/8 上午11:42
 * @Description
 **/


@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private RedisTemplate redisTemplate;


    @Override
    public String get() {
        return null;
    }
}
