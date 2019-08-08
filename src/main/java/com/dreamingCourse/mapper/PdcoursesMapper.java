package com.dreamingCourse.mapper;

import com.dreamingCourse.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* 查询已购买课程
* */
@Mapper
@Repository
public interface PdcoursesMapper {

    //查询已购买课程
    public List<Course> findpcourses(Integer id);
}
