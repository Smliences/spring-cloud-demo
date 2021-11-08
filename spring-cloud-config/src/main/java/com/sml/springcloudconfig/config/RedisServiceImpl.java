package com.sml.springcloudconfig.config;

import com.sml.springcloudcommon.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author sml
 * @Date 2021/11/8 下午2:15
 * @Description
 **/


@Service
public class RedisServiceImpl implements RedisService {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 默认过期时间
     */
    private static final Integer EXPIRED_TIME = 60 * 60;

    /**
     * 储存默认时间
     *
     * @param redisKey
     * @param redisValue
     */
    @Override
    public void setRedisValue(String redisKey, String redisValue) {
        redisTemplate.opsForValue().set(redisKey, redisValue, EXPIRED_TIME, TimeUnit.SECONDS);
    }

    /**
     * 储存传入时间
     *
     * @param redisKey
     * @param redisValue
     * @param time
     */
    @Override
    public void setRedisValue(String redisKey, String redisValue, Integer time) {
        redisTemplate.opsForValue().set(redisKey, redisValue, time, TimeUnit.SECONDS);
    }

    /**
     * 储存传入时间
     * 自定义时间单位
     * @param redisKey
     * @param redisValue
     * @param time
     * @param timeUnit
     */
    @Override
    public void setRedisValue(String redisKey, String redisValue, long time, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(redisKey, redisValue, time, timeUnit);
    }

    /**
     * 永久储存
     *
     * @param redisKey
     * @param redisValue
     */
    @Override
    public void setRedisValuePerpetual(String redisKey, String redisValue) {
        redisTemplate.opsForValue().set(redisKey, redisValue);
    }

    /**
     * 根据key获得value
     *
     * @param redisKey
     * @return
     */
    @Override
    public String getRedisValueByKey(String redisKey) {
        return redisTemplate.opsForValue().get(redisKey);
    }

    /**
     * 根据key删除value
     *
     * @param redisKey
     */
    @Override
    public void deleteRedisValueByKey(String redisKey) {
        redisTemplate.delete(redisKey);
    }

    /**
     * 删除redis 文件夹
     *
     * @param redisKey
     */
    @Override
    public void deleteRedisFolderByKey(String redisKey) {
        Set<String> keys = redisTemplate.keys(redisKey);
        redisTemplate.delete(keys);
    }

    /**
     * 获取锁
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    @Override
    public boolean getLock(String key, String value, int expireTime) {

        // 设置锁，设置前判断Key是否已存在，不存在则，设置key，value，
        // 然后返回true。
        // 如果锁已存在 则返回false，
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            // 设置Key过期时间，防止死锁
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 释放锁，如果锁不存在
     * */
    @Override
    public void releaseLock(String key){
        this.deleteRedisValueByKey(key);
    }

}
