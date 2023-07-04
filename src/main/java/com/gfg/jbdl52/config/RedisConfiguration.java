package com.gfg.jbdl52.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfiguration {

/***
 * Connection bean -> it will create connection with redis
 * Template bean -> to access the data.
 * */

   @Bean
    public LettuceConnectionFactory getRedisConnection(){
        RedisStandaloneConfiguration redisStandaloneConfiguration=new RedisStandaloneConfiguration("redis-12100.c283.us-east-1-4.ec2.cloud.redislabs.com",12100);
        redisStandaloneConfiguration.setPassword("<PASSWORD_HERE>");
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean("redisTemplate")
    @Primary
    public RedisTemplate<String,Object> getRedisTemplate(LettuceConnectionFactory lettuceConnectionFactory){
        RedisTemplate template=new RedisTemplate();
        template.setConnectionFactory(lettuceConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        return template;
    }




}


/****
 * Caching -> 
 * Lettuce
 * Jedis
 *
 * are the 2 driver which will support the redis operations
 *
 * <"TopMovies",List
 *
 * */
