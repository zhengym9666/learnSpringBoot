package com.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;


    @RequestMapping("/sendMsg")
    public String sendMsg() {
        System.out.println("####sendMsg####1");
        asyncService.sendSms();
        System.out.println("####sendMsg####2");
        return "success";
    }

}
