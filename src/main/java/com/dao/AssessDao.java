package com.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.Ykt_assess;
import com.mapper.AssessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssessDao {
	@Autowired
	AssessMapper assessMapper;

	public List<Ykt_assess> getList() {
		return assessMapper.selectList(null);
	}

	public Ykt_assess getById(int i) {
		return assessMapper.selectById(i);
	}

	public Page<Ykt_assess> getListPageByCourseId(int id, int page){
		Page<Ykt_assess> page1 = new Page<>();
		page1.setSize(20);
		page1.setCurrent(page);
		QueryWrapper<Ykt_assess> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(true,"course_id", id)
				.eq(true,"is_alive", 1);
		return (Page<Ykt_assess>) assessMapper.selectPage(page1, queryWrapper);
	}
}
