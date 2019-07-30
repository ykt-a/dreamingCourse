package com.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entity.Ykt_course;
import com.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao {
	@Autowired
	CourseMapper courseMapper;

	public List<Ykt_course> getList(){
		return courseMapper.selectList(null);
	}

	public Ykt_course getById(int i){
		return courseMapper.selectById(i);
	}

	public List<Ykt_course> getListByTagId(int tagId){
		return courseMapper.selectList(new QueryWrapper<Ykt_course>().eq("tag_id", tagId));
	}
}
