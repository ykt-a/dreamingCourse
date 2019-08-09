package com.dreamingCourse.controller;


import com.alibaba.fastjson.JSON;
import com.dreamingCourse.service.ServiceGetList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class ControllerGetList {

	@Autowired
	ServiceGetList serviceGetList;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	//三级菜单
	@RequestMapping("/getcourselist")
	public String getCourseList(HttpServletRequest request) {
		String name = request.getParameter("name");
		int page = Integer.parseInt(request.getParameter("page"));
		String courstlist;
		if ((courstlist = (String) stringRedisTemplate.opsForValue().get("courselist:" + name+":page:"+page)) != null) {
			System.out.println("----getCourseList 缓存----------");

			return courstlist;
		}

		Map list = serviceGetList.getCourseListByTagName(name,page);

		courstlist = JSON.toJSONString(list);
		stringRedisTemplate.opsForValue().set("courselist:" + name+":page:"+page, courstlist, 10, TimeUnit.MINUTES);
		System.out.println("----getCourseList 数据库----------");

		return courstlist;
	}


	//二层菜单
	@RequestMapping("/getparentlist")
	public String getParentList(HttpServletRequest request) {
		String name = request.getParameter("name");
		String courseTagList;
		if ((courseTagList=stringRedisTemplate.opsForValue().get("coursetaglist:"+name))!=null){
			System.out.println("----getParentList 缓存----------");

			return courseTagList;
		}
		List<String> list = serviceGetList.getCourseTagByParentTagName(name);
		courseTagList = JSON.toJSONString(list);
		stringRedisTemplate.opsForValue().set("coursetaglist:"+name, courseTagList, 1, TimeUnit.DAYS);
		System.out.println("----getParentList 数据库----------");

		return courseTagList;
	}

}
