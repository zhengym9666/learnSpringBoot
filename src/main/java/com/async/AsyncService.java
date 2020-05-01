package com.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    //在Spring Boot的主类中加入@EnableAsync，启用异步调用
    //异步调用相当于开启一个线程单独跑
    @Async
    public String sendSms() {
        System.out.println("####sendSms####3");
        for (int i = 0; i < 4; i++) {
            System.out.println("i:"+i);
        }
        System.out.println("####sendSms####4");
        return "success";
    }

}
