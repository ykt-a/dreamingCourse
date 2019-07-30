package com.dao;


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
}
