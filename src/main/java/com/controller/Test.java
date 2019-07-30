package com.controller;


import com.entity.Ykt_teacher;
import com.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Test {

	@Autowired
	TeacherMapper teacherMapper;

	@RequestMapping("/")
	public List<Ykt_teacher> demo(){
		List<Ykt_teacher> list = teacherMapper.selectList(null);
		return list;
	}
}
