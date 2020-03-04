package com.database.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class JpaController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/JpaFind")
    public String JpaFind() {
        Optional<User> optional = userDao.findById(3);
        User user =  optional.get();
        return user.getPassword();
    }

}
