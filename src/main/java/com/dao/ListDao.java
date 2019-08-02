package com.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entity.Ykt_list;
import com.mapper.ListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListDao {
	@Autowired
	ListMapper listMapper;

	public List<Ykt_list> getList(){
		return listMapper.selectList(null);
	}

	public Ykt_list getById(int i){
		return listMapper.selectById(i);
	}

	public List<Ykt_list> getByCourseId(int id){
		QueryWrapper<Ykt_list> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("course_id", id)
				.eq("is_alive", 1);
		return listMapper.selectList(queryWrapper);
	}
}
