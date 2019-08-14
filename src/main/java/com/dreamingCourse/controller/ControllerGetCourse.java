package com.dreamingCourse.controller;


import com.alibaba.fastjson.JSON;
import com.dreamingCourse.model.AssessModel;
import com.dreamingCourse.model.ChapterModel;
import com.dreamingCourse.model.CourseDetailModel;
import com.dreamingCourse.service.ServiceGetCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class ControllerGetCourse {

	@Autowired
	ServiceGetCourse serviceGetCourse;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@RequestMapping("/getcourse")
	public String getCourseById(HttpServletRequest request) {
		String course;
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		Integer userId = null;
		String string = request.getParameter("userId");
		if (string.equals("")) userId = null;
		else userId = Integer.valueOf(string);

		if ((course = stringRedisTemplate.opsForValue().get("courseDetail:courseId:" + courseId + ":userId:" + userId)) != null) {
			System.out.println("----getCourseById 缓存----------");
			return course;
		}


		CourseDetailModel courseDetailModel = serviceGetCourse.getCourseDetailById(userId, courseId);
		if (courseDetailModel == null) {
			course = "课程被关闭";
		} else {
			course = JSON.toJSONString(courseDetailModel);
		}
		stringRedisTemplate.opsForValue().set("courseDetail:courseId:" + courseId + ":userId:" + userId, course, 10, TimeUnit.MINUTES);
		System.out.println("----getCourseById 数据库----------");
		return course;
	}

	@RequestMapping("/getcoursechapter")
	public String getCourseChapter(HttpServletRequest request) {
		String json;
		List<ChapterModel> chapterModels;
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		Boolean isBuy = Boolean.parseBoolean(request.getParameter("isBuy"));
		System.out.println(isBuy);
		if ((json = stringRedisTemplate.opsForValue().get("chapter:courseId:" + courseId + ":isBuy:" + isBuy.toString())) != null) {
			System.out.println("----getCourseChapter 缓存----------");
			return json;
		}
		if (isBuy) {
			chapterModels = serviceGetCourse.getFullChapterByCourseId(courseId);
			json = JSON.toJSONString(chapterModels);
		} else{
			chapterModels = serviceGetCourse.getChapterByCourseId(courseId);
			json = JSON.toJSONString(chapterModels);

		}
		stringRedisTemplate.opsForValue().set("chapter:courseId:" + courseId + ":isBuy:" + isBuy.toString(), json, 10, TimeUnit.MINUTES);
		System.out.println("----getCourseChapter 数据库----------");
		return json;
	}

	@RequestMapping("/getcourseassess")
	public String getCourseAssess(HttpServletRequest request) {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		int page = Integer.parseInt(request.getParameter("page"));
		String json;
		List<AssessModel> assessModels;
		if ((json = stringRedisTemplate.opsForValue().get("assess:courseId:" + courseId + ":page:" + page)) != null) {
			System.out.println("----getCourseAssess 缓存----------");
			return json;
		}
		Map map = serviceGetCourse.getCourseAssessByCourseId(courseId, page);
		json = JSON.toJSONString(map);
		stringRedisTemplate.opsForValue().set("assess:courseId:" + courseId + ":page:" + page, json, 5, TimeUnit.MINUTES);
		System.out.println("----getCourseAssess 数据库----------");

		return json;
	}
}
