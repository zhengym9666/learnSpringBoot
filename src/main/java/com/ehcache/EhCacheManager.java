package com.ehcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;

public class EhCacheManager {

    @Autowired
    private CacheManager cacheManager;

    public void removeCache() {
        cacheManager.getCache("baseCache").clear();
    }

}
