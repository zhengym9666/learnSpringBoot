package com.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

//ControllerAdvice：controller的辅助类，常用做全局异常处理的切面类
//切面异常拦截，拦截了多个异常的话，默认只取第一个异常
@ControllerAdvice(basePackages = "com.controller")
public class GlobalExceptionHandler {
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    @ResponseBody //拦截返回的是json
    public Map<String,Object> exceptionHandler() {
        Map<String,Object> map = new HashMap<>();
        map.put("errorCode","401");
        map.put("errorMsg","数组越界");
        return map;
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView runtimeExceptionHandler() {
        /*Map<String,Object> map = new HashMap<>();
        map.put("errorCode","402");
        map.put("errorMsg","请求超时");*/
        return new ModelAndView("404");
    }
}
