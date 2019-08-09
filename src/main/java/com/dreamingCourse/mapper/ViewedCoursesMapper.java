package com.dreamingCourse.mapper;

import com.dreamingCourse.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ViewedCoursesMapper {
    public List<Course> fviewedCourses(List<Integer> list);

}
