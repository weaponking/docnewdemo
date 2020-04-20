package com.mine.docdemo.redis;

import com.mine.docdemo.redis.config.RedisConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Arrays;

/**
 * @author weapon
 * @date 2020/4/12 14:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class})
@Slf4j
public class TestLuaCase {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    @Qualifier("lockLuaScript")
    private RedisScript<String> lockLuaScript;

    @Autowired
    @Qualifier("unlockLuaScript")
    private RedisScript<Boolean> unlockLuaScript;

    private static final String LOCK_KEY = "LOCK_KEY";

    private static final String LOCK_VALUE = "LOCK_VALUE";

    private static final String NEW_LOCK_VALUE = "NEW_LOCK_VALUE";

    private static final String TIME_OUT = "30";

    @Test
    public void test1() {
        String result = redisTemplate.execute(lockLuaScript, Arrays.asList(LOCK_KEY), LOCK_VALUE, TIME_OUT);
        Assert.assertEquals(LOCK_VALUE, result);
        boolean result1 = redisTemplate.execute(unlockLuaScript, Arrays.asList(LOCK_KEY), LOCK_VALUE);
        Assert.assertEquals(Boolean.TRUE, result1);
        result = redisTemplate.execute(lockLuaScript, Arrays.asList(LOCK_KEY), NEW_LOCK_VALUE, TIME_OUT);
        Assert.assertEquals(NEW_LOCK_VALUE, result);
    }

    @Test
    public void test2() {
        boolean result = redisTemplate.execute(unlockLuaScript, Arrays.asList(LOCK_KEY), LOCK_VALUE);
        Assert.assertEquals(result, Boolean.TRUE);
    }

}
