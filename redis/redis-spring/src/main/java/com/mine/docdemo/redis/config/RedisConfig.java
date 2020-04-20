package com.mine.docdemo.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author weapon
 * @date 2020/4/4 19:39
 */
@Configuration
@PropertySource(value = {"classpath:redis-config.properties"})
public class RedisConfig {

    @Value("${redis.maxTotal}")
    private Integer maxTotal;
    @Value("${redis.maxIdle}")
    private Integer maxIdle;
    @Value("${redis.maxWaitMillis}")
    private Long maxWaitMillis;
    @Value("${redis.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;
    @Value("${redis.timeout}")
    private Integer timeout;
    @Value("${redis.password}")
    private String password;

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        return jedisPoolConfig;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setUsePool(true);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPassword(password);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.setTimeout(timeout);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory);
        return stringRedisTemplate;
    }

    @Bean
    public RedisScript<String> lockLuaScript() {
        DefaultRedisScript<String> redisScript = new DefaultRedisScript<>();
        redisScript.setLocation(new ClassPathResource("lua/lock.lua"));
        redisScript.setResultType(String.class);
        return redisScript;
    }

    @Bean
    public RedisScript<Boolean> unlockLuaScript() {
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setLocation(new ClassPathResource("lua/unlock.lua"));
        redisScript.setResultType(Boolean.class);
        return redisScript;
    }
}
