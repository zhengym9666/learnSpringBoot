package com.multiDatasource.controller;

import com.multiDatasource.entity.User1;
import com.multiDatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/find")
public class TestController {


    @Autowired
    private UserService service;

    @RequestMapping("/test1")
    public String find1() {
        User1 user = service.getByMapper1("张三");
        return user.getPassword();
    }

    @RequestMapping("/test2")
    public String find2() {
        User1 user = service.getByMapper2("张三2");
        return user.getPassword();
    }

    @RequestMapping("transaction")
    public void testTransaction(){
        service.insert();
    }

}
