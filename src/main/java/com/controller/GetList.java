package com.controller;


import com.alibaba.fastjson.JSON;
import com.model.CourseModel;
import com.service.GetCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class GetList {

	@Autowired
	GetCourse getCourse;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	//三级菜单
	@RequestMapping("/getCourseList")
	public String getCourseList(HttpServletRequest request) {
		String name = request.getParameter("name");
		String courstlist;
		if ((courstlist = (String) stringRedisTemplate.opsForValue().get("courselist:" + name)) != null) {
			System.out.println("————————缓存中取————————————————————");
			return courstlist;
		}

		System.out.println("————————数据库中取——————————");
		List<CourseModel> list = getCourse.getCourseListByTagName(name);

		courstlist = JSON.toJSONString(list);
		stringRedisTemplate.opsForValue().set("courselist:" + name, courstlist, 1, TimeUnit.DAYS);

		return courstlist;
	}


	//二层菜单
	@RequestMapping("/getParentList")
	public String getCourseTagList(HttpServletRequest request) {
		String name = request.getParameter("name");
		String courseTagList;
		if ((courseTagList=stringRedisTemplate.opsForValue().get("coursetaglist:"+name))!=null){
			return courseTagList;
		}
		List<String> list = getCourse.getCourseTagByParentTagName(name);
		courseTagList = JSON.toJSONString(list);
		stringRedisTemplate.opsForValue().set("coursetaglist:"+name, courseTagList, 1, TimeUnit.DAYS);
		return courseTagList;
	}

}
