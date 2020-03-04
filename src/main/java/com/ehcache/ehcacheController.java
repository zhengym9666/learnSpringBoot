package com.ehcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ehcache")
public class ehcacheController {

    @Autowired
    private CUserService userService;

    @RequestMapping("/test")
    public String find() {
        CUser user = userService.getUser("zhengym-1");
        return user.getPassword();
    }


}
