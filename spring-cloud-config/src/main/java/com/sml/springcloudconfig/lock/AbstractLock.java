package com.sml.springcloudconfig.lock;

import com.sml.springcloudcommon.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author sml
 * @Date 2021/11/8 下午2:36
 * @Description
 **/


public abstract class AbstractLock implements Lock{
    @Resource
    private RedisService redisService;

    @Override
    public Boolean lock(String key) {
        System.out.println("获取锁");
        return redisService.getLock(key, UUID.randomUUID().toString(), 1);
    }

    @Override
    public Boolean unlock(String key) {
        System.out.println("释放锁");
         redisService.releaseLock(key);
         return true;
    }
}
