package com.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

	public Ykt_course getAliveById(int id){
		QueryWrapper<Ykt_course> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("is_alive", 1);
		return courseMapper.selectOne(queryWrapper);
	}

	public Page<Ykt_course> getPageByTagId(int tagId, int pagecount){
		Page<Ykt_course> page = new Page();
		page.setCurrent(pagecount);
		page.setSize(10);
		QueryWrapper<Ykt_course> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("tag_id", tagId)
				.eq("is_alive", 1);
		return (Page<Ykt_course>) courseMapper.selectPage(page, queryWrapper);
	}
}
