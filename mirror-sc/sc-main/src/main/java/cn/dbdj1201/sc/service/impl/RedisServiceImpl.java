package cn.dbdj1201.sc.service.impl;

import cn.dbdj1201.sc.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-09 15:06
 */
@Service
public class RedisServiceImpl implements IRedisService {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean expire(String key, long expire) {
        Assert.notNull(key, "不可能空");
        Boolean flag = redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        Assert.notNull(flag, "不可能空");
        return flag;
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }
}
