package cn.dbdj1201.sc.service.impl;

import cn.dbdj1201.sc.ScMainApp40923;
import cn.dbdj1201.sc.service.IRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-09 15:15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisServiceImplTest {

    @Autowired
    IRedisService redisService;

    @Test
    public void set() {
//        redisService.set("test","test");

        redisService.expire("test",120);
    }
}