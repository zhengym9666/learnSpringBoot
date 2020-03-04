package com.database.jdbc;

import org.springframework.stereotype.Service;


public interface UserService {

    public int createUser(String username,String password);

}
