package com.sml.springcloudconfig.lock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author sml
 * @Date 2021/11/8 下午2:34
 * @Description
 **/


@Aspect
@Component
public class RedisLock extends AbstractLock {


    @Around("@annotation(EnableLock)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        String name = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        String lockKey = name + ":" + methodName;
        Object proceed;
        try {
            if (lock(lockKey)) {
                proceed = pjp.proceed();
            } else {
                System.out.println("获取分布式锁失败, key=" + lockKey);
                throw new RuntimeException("获取分布式锁失败，请稍后重试");
            }
        } catch (Exception e) {
            throw new Exception();
        } finally {
            unlock(lockKey);
        }
        return proceed;
    }
}
