package com.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entity.Ykt_teacher;
import com.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDao {

	@Autowired
	TeacherMapper teacherMapper;

	public List<Ykt_teacher> getList() {
		return teacherMapper.selectList(null);
	}

	public Ykt_teacher getById(int id) {
		return teacherMapper.selectById(id);
	}

	public Ykt_teacher getByCourseId(int id) {
		return teacherMapper.selectOne(new QueryWrapper<Ykt_teacher>().eq(true, "cources_id", id));
	}
}
