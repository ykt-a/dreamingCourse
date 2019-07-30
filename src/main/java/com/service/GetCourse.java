package com.service;


import com.dao.CourseDao;
import com.dao.TagDao;
import com.entity.Ykt_course;
import com.entity.Ykt_tag;
import com.model.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetCourse {

	@Autowired
	CourseDao courseDao;

	@Autowired
	TagDao tagDao;

	@Autowired
	CourseModel courseModel;

	public List<CourseModel> getCourseListByTagName(String name) {

		int tagId = tagDao.getIdByName(name);
		List<Ykt_course> list = courseDao.getListByTagId(tagId);
		List<CourseModel> list1 = new ArrayList<>();
		for (Ykt_course temp: list){
			list1.add(courseModel.init(temp,tagDao));
		}
		return list1;
	}

	public List<String> getCourseTagByParentTagName(String name){
		int id = tagDao.getIdByName(name);
		List<Ykt_tag> list = tagDao.getTagNameByParentTagId(id);
		List<String> list1 = new ArrayList<>();
		for (Ykt_tag temp : list){
			list1.add(temp.getName());
		}
		return list1;
	}
}
