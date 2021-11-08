package com.sml.springcloudcommon.redis;

import java.util.concurrent.TimeUnit;

public interface RedisService {

    /**
     * 储存默认时间
     *
     * @param redisKey
     * @param redisValue
     */
    void setRedisValue(String redisKey, String redisValue);

    /**
     * 储存传入时间
     *
     * @param redisKey
     * @param redisValue
     * @param time 秒
     */
    void setRedisValue(String redisKey, String redisValue, Integer time);

    /**
     * 储存传入时间
     * 自定义时间单位 （小时、秒等等）
     * @param redisKey
     * @param redisValue
     * @param time 时间
     * @param timeUnit 时间单位
     */
    void setRedisValue(String redisKey, String redisValue, long time, TimeUnit timeUnit);

    /**
     * 永久储存
     *
     * @param redisKey
     * @param redisValue
     */
    void setRedisValuePerpetual(String redisKey, String redisValue);

    /**
     * 根据key获得value
     *
     * @param redisKey
     * @return
     */
    String getRedisValueByKey(String redisKey);

    /**
     * 根据key删除value
     *
     * @param redisKey
     */
    void deleteRedisValueByKey(String redisKey);

    /**
     * 删除redis 文件夹
     *
     * @param redisKey
     */
    void deleteRedisFolderByKey(String redisKey);

    /**
     * 获取锁
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    boolean getLock(String key, String value, int expireTime);

    /**
     * 释放锁
     * @param key
     */
    void releaseLock(String key);

}
