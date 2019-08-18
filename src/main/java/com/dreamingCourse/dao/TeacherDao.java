package com.dreamingCourse.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dreamingCourse.entity.Ykt_teacher;
import com.dreamingCourse.mapper.TeacherMapper;
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
		QueryWrapper<Ykt_teacher> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(true,"cources_id", id);
		return teacherMapper.selectOne(queryWrapper);
	}


}
