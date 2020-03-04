package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//restful接口:通过url的方式访问后端的代码，常用：get/post方式
//声明该controller所有的方法返回json格式可以直接编写restful接口
//@RestController
@Controller //可以返回视图
//自动为springboot应用进行配置
//@EnableAutoConfiguration
public class FreemarkerController {

    @RequestMapping("/frmIndex")
    public String index(Map<String,Object> map) {
        System.out.println("使用freemarker模板引擎");
        map.put("name","zhengym");
        map.put("sex",1);
        List<String> userList = new ArrayList<>();
        userList.add("张三");
        userList.add("李四");
        userList.add("王五");
        map.put("userList",userList);
        return "index2";
    }
}
