package com.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//restful接口:通过url的方式访问后端的代码，常用：get/post方式
//声明该controller所有的方法返回json格式可以直接编写restful接口
//@RestController
@Controller //可以返回视图
//自动为springboot应用进行配置
//@EnableAutoConfiguration
@RequestMapping("controller")
public class HelloController {

    @RequestMapping("/myIndex")
    public String index() {
        System.out.println("hello.springboot的第一个controller");
        return "index1";
    }

    @RequestMapping("/test")
    public String test() {
        /*int[] arr = new int[1];
        System.out.println(arr[2]);*/
        throw new RuntimeException("超时");
//        return "test ControllerAdvice";
    }
}
