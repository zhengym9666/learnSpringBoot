package com.ehcache;

import com.ehcache.test1.CuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "baseCache") //用来描述该类中所有方法使用的缓存名称
public class CUserService {

    @Autowired
    private CuserMapper userMapper;

    @Cacheable(key = "#username")
    public CUser getUser(String username) {
        System.out.println("java缓存框架ehcache....");
        CUser user = userMapper.findByName(username);
        return user;
    }

//    这个注解一般加在更新方法上，当数据库中的数据更新后，缓存中的数据也要跟着更新，使用该注解，可以将方法的返回值自动更新到已经存在的 key 上，示例代码如下：
    @CachePut(key = "#user.id")
    public CUser updateUserById(CUser user) {
        return user;
    }

//    这个注解一般加在删除方法上，当数据库中的数据删除后，相关的缓存数据也要自动清除，该注解在使用的时候也可以配置按照某种条件删除（ condition 属性）或者或者配置清除所有缓存（ allEntries 属性），示例代码如下：
    @CacheEvict()
    public void deleteUserById(Integer id) {
        //在这里执行删除操作， 删除是去数据库中删除
    }

}
