package com.log4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @RequestMapping("test4j")
    public String testLog4j() {
        return "测试log4j";
    }

}
