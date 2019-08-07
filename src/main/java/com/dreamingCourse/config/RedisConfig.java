package com.dreamingCourse.config;

import com.dreamingCourse.utils.redis.RedisObjectSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author zth
 * @Date 2019-08-05 1:06
 */

@Configuration
public class RedisConfig  {
    @Bean
    public RedisTemplate<String, Object> getRedisTemplate(
            RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer()); // key的序列化类型
        redisTemplate.setValueSerializer(new RedisObjectSerializer()); // value的序列化类型
        return redisTemplate;
    }
}
