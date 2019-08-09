package com.dreamingCourse.controller;

import com.dreamingCourse.entity.Course;
import com.dreamingCourse.service.impl.ViewedCoursesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("/user")
public class ViCoursesController {
    @Autowired
    ViewedCoursesServiceImpl viewedCoursesServiceimpl;

        @RequestMapping("/findViCourses")
    public @ResponseBody List<Course> findViCourses(Integer uid){

        return viewedCoursesServiceimpl.fviewedCourses(uid);
    }
        @RequestMapping("/saveViCourses")
    public void saveViCourses(Integer uid,Integer cid){

        viewedCoursesServiceimpl.sviewedCourses(uid,cid);
        System.out.println("-----在缓存中添加");

    }
}
