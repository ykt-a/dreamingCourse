package com.dreamingCourse.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dreamingCourse.dao.CourseDao;
import com.dreamingCourse.dao.TagDao;
import com.dreamingCourse.entity.Ykt_course;
import com.dreamingCourse.entity.Ykt_tag;
import com.dreamingCourse.model.CourseListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceGetList {

	@Autowired
	CourseDao courseDao;

	@Autowired
	TagDao tagDao;

	@Autowired
	CourseListModel courseListModel;

	public Map<String,Object> getCourseListByTagName(String name, int pagecount) {
		Map<String,Object> map= new HashMap<>();
		int tagId = tagDao.getIdByName(name);
		Page<Ykt_course> page = courseDao.getPageByTagId(tagId,pagecount);
		List<Ykt_course> list = page.getRecords();
		List<CourseListModel> list1 = new ArrayList<>();
		for (Ykt_course temp: list){
			list1.add(courseListModel.init(temp,tagDao));
		}
		map.put("hasNextPage", page.hasNext());
		map.put("data", list1);
		return map;
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
