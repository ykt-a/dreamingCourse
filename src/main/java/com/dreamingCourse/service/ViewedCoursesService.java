package com.dreamingCourse.service;

import com.dreamingCourse.entity.Course;

import java.util.List;

public interface ViewedCoursesService {
    List<Course> fviewedCourses(Integer uid);
    void sviewedCourses(Integer uid,Integer cid);
}
