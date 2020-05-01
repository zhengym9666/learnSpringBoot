package com;

import com.multiDatasource.config.DBConfig1;
import com.multiDatasource.config.DBConfig2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


//标识为springboot启动类,必须是父路径，其他包路径必须是其子路径
@SpringBootApplication(scanBasePackages = {"com.multiDatasource","com.log4j","com.redis","com.schedule","com.async"})
@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
//@ComponentScan(basePackages = "com")
//@MapperScan("com.ehcache")//扫描mapper
@EnableCaching //开启缓存
@EnableScheduling//开启定时任务
@EnableAsync //开启异步调用
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

}
