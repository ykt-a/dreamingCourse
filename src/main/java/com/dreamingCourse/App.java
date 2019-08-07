package com.dreamingCourse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zth
 * @Date 2019-07-23 10:59
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.dreamingCourse.mapper")
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
}
