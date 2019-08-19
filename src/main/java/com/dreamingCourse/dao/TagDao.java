package com.dreamingCourse.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dreamingCourse.entity.Ykt_tag;
import com.dreamingCourse.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagDao {
	@Autowired
	TagMapper tagMapper;

	public List<Ykt_tag> getList() {
		return tagMapper.selectList(null);
	}

	public Ykt_tag getById(int i) {
		return tagMapper.selectById(i);
	}

	public int getIdByName(String name) {
		return tagMapper.selectOne(new QueryWrapper<Ykt_tag>().eq(true,"name", name)).getId();
	}

	public String getTagNameById(int id) {
		return tagMapper.selectOne(new QueryWrapper<Ykt_tag>().eq("id", id).eq("is_alive", 1)).getName();
	}

	public List<Ykt_tag> getTagNameByParentTagId(int id){
		return tagMapper.selectList(new QueryWrapper<Ykt_tag>().eq("parent_id", id));
	}
}
