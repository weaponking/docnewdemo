package com.mine.docdemo.redis;

import com.mine.docdemo.redis.config.RedisConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author weapon
 * @date 2020/4/4 19:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class})
@Slf4j
public class TestCase {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    public void test() {

        redisTemplate.opsForValue().set("num","123");
        log.info(redisTemplate.opsForValue().get("num"));
    }

}
