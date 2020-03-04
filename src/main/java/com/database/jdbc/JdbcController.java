package com.database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jdbc")
public class JdbcController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public String save() {
        userService.createUser("张三","zhangsan");
        return "success";
    }

}
