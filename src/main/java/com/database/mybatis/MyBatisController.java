package com.database.mybatis;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mybatis")
public class MyBatisController {

    @Autowired
    private UserMapper mapper;

    @RequestMapping("/find")
    public String find() {
        User user = mapper.findByName("张三");
        return user.getPassword();
    }


}
