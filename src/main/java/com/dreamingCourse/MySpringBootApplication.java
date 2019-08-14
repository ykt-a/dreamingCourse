package com.dreamingCourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//@MapperScan("com.dreamingCourse.mapper.puchasedcourses.PdcoursesMapper")   <SpringBootApplication>
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class,args);
    }
}
