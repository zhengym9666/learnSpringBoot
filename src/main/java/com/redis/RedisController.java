package com.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class RedisController {

    private static Logger log = LoggerFactory.getLogger(RedisUserService.class);

    @Autowired
    private RedisUserService userService;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @RequestMapping("/redis/{id}")
    public String testRedis(@PathVariable(value = "id")String id) {
        String str = "";
        //序列化字符串
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        if (redisTemplate.hasKey(id)) {
            //获取缓存
            log.info("从redis中取数据");
            RedisUser user = (RedisUser) redisTemplate.opsForValue().get(id);
            str = user.toString();
        } else {
            //获取数据库
            log.info("从数据库中取数据");
            RedisUser user = userService.getUser(Integer.parseInt(id));
            str = user.toString();
            //往缓存中存
            ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
            operations.set(id,user);
//            redisTemplate.opsForValue().set(id,user);
            log.info("数据插入redis");
        }
        return str;
    }

}
