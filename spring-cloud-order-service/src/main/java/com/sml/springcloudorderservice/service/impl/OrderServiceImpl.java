package com.sml.springcloudorderservice.service.impl;

import com.sml.springcloudcommon.redis.RedisService;
import com.sml.springcloudorderservice.service.OrderService;
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
    private RedisService redisService;


    @Override
    public String get(String key) {
        return String.valueOf(redisService.getRedisValueByKey(key));
    }

    @Override
    public void set(String key, String value) {
        redisService.setRedisValue(key,value);
    }
}
