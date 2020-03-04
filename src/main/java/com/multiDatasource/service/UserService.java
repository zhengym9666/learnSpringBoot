package com.multiDatasource.service;

import com.multiDatasource.entity.User1;
import com.multiDatasource.test1.User1Mapper;
import com.multiDatasource.test2.User2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private User1Mapper mapper1;

    @Autowired
    private User2Mapper mapper2;

    public User1 getByMapper1(String name) {
        User1 user = mapper1.findByName(name);
        return user;
    }

    public User1 getByMapper2(String name) {
        User1 user = mapper2.findByName(name);
        return user;
    }

    @Transactional
    public void insert() {
        mapper1.insert("事务","shiwu");
//        int i = 1/0;
        mapper2.insert("事务2","shiwu2");
    }
}
