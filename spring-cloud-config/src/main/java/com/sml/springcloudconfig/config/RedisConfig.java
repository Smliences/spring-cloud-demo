package com.sml.springcloudconfig.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;


@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
//    /**
//     *  默认 redis
//     *  设置 redis 数据默认过期时间
//     *  设置@cacheable 序列化方式
//     * @return
//     */
//    @Bean
//    public RedisCacheConfiguration redisCacheConfiguration(){
//        //fastjson 1.2.x版本之后打开 autotype 否则使用注解重启tomcat后反序列化会报错
//        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//        RedisFastJsonSerializer<Object> fastJsonRedisSerializer = new RedisFastJsonSerializer<>(Object.class);
//        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
//        configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(fastJsonRedisSerializer)).entryTtl(Duration.ofDays(30));
//        return configuration;
//    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        template.setConnectionFactory(factory);
        template.setEnableTransactionSupport(true);
        return template;
    }


}
