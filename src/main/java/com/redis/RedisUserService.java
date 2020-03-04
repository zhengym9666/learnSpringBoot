package com.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

@Service
public class RedisUserService {

    @Autowired
    private RedisUserMapper userMapper;

    public RedisUser getUser(int id) {
        RedisUser user = userMapper.findById(id);
        return user;
    }
}
