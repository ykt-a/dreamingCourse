package com.dreamingCourse.service;

import com.dreamingCourse.entity.Course;

import java.util.List;

public interface FpcourseService {
    /*
    * 查询已购买的课程
    * */
     List<Course> findpcouses(Integer id);
}
