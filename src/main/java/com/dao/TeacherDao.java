package com.dao;

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

	public Ykt_teacher getById(int id){
		return teacherMapper.selectById(id);
	}
}
