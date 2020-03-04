package com.database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

//使用spring框架需要加上特定的注解
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createUser(String username, String password) {
        System.out.println("ssss");
        int update = jdbcTemplate.update("insert into user_table values(4,?,?);", username, password);
        return update;
    }
}
