package com.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

//在Spring Boot的主类中加入@EnableScheduling注解，启用定时任务的配置
@Component
public class ScheduledTask {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 2000)
    public void reportTime(){
        System.out.println("当前时间："+sdf.format(new Date().getTime()));
    }
}
