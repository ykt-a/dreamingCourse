package com.dreamingCourse.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dreamingCourse.entity.Ykt_seckill_goods;
import com.dreamingCourse.mapper.YktSecKillGoodsMapper;
import com.dreamingCourse.model.AssessModel;
import com.dreamingCourse.model.ChapterModel;
import com.dreamingCourse.model.CourseDetailModel;
import com.dreamingCourse.service.ServiceGetCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@CrossOrigin
@RestController
public class ControllerGetCourse {
	@Autowired
	YktSecKillGoodsMapper yktSecKillGoodsMapper;

	@Autowired
	ServiceGetCourse serviceGetCourse;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@RequestMapping("/getcourse")
	public JSON getCourseById(HttpServletRequest request) {
		String course;
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		Integer userId = null;
		String string = request.getParameter("userId");
		String kill = request.getParameter("kill");
		if (string == null || string.equals("")) userId = null;
		else userId = Integer.valueOf(string);

		if (kill == null && (course = stringRedisTemplate.opsForValue().get("courseDetail:courseId:" + courseId + ":userId:" + userId)) != null) {
			System.out.println("----getCourseById 缓存----------");
			return JSON.parseObject(course);
		}


		CourseDetailModel courseDetailModel = serviceGetCourse.getCourseDetailById(userId, courseId);
		if (courseDetailModel == null) {
			course = "{\"stat\":\"课程被关闭\"}";
		} else if (kill == null) {
			course = JSON.toJSONString(courseDetailModel);
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
			courseDetailModel.setDate(format.format(new Date()));
			Ykt_seckill_goods ykt_seckill_goods= yktSecKillGoodsMapper.selectOne(new QueryWrapper<Ykt_seckill_goods>().eq(true,"is_alive", 1).eq(true,"cid", courseId));
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			String date = format1.format(ykt_seckill_goods.getStartDay())+" "+ykt_seckill_goods.getStartTime();
			courseDetailModel.setStartTime(date);
			course = JSON.toJSONString(courseDetailModel);
		}
		if (kill == null) {
			stringRedisTemplate.opsForValue().set("courseDetail:courseId:" + courseId + ":userId:" + userId, course, 10, TimeUnit.MINUTES);
		}
		System.out.println("----getCourseById 数据库----------");
		return JSON.parseObject(course);
	}

	@RequestMapping("/getcoursechapter")
	public JSONArray getCourseChapter(HttpServletRequest request) {
		String json;
		List<ChapterModel> chapterModels;
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		Boolean isBuy = Boolean.parseBoolean(request.getParameter("isBuy"));
		System.out.println(isBuy);
		if ((json = stringRedisTemplate.opsForValue().get("chapter:courseId:" + courseId + ":isBuy:" + isBuy.toString())) != null) {
			System.out.println("----getCourseChapter 缓存----------");
			return JSONArray.parseArray(json);
		}
		if (isBuy) {
			chapterModels = serviceGetCourse.getFullChapterByCourseId(courseId);
			json = JSON.toJSONString(chapterModels);
		} else {
			chapterModels = serviceGetCourse.getChapterByCourseId(courseId);
			json = JSON.toJSONString(chapterModels);

		}
		stringRedisTemplate.opsForValue().set("chapter:courseId:" + courseId + ":isBuy:" + isBuy.toString(), json, 10, TimeUnit.MINUTES);
		System.out.println("----getCourseChapter 数据库----------");
		return JSONArray.parseArray(json);
	}

	@RequestMapping("/getcourseassess")
	public JSONObject getCourseAssess(HttpServletRequest request) {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		int page = Integer.parseInt(request.getParameter("page"));
		String json;
		List<AssessModel> assessModels;
		if ((json = stringRedisTemplate.opsForValue().get("assess:courseId:" + courseId + ":page:" + page)) != null) {
			System.out.println("----getCourseAssess 缓存----------");
			return JSONObject.parseObject(json);
		}
		Map map = serviceGetCourse.getCourseAssessByCourseId(courseId, page);
		json = JSON.toJSONString(map);
		stringRedisTemplate.opsForValue().set("assess:courseId:" + courseId + ":page:" + page, json, 5, TimeUnit.MINUTES);
		System.out.println("----getCourseAssess 数据库----------");

		return JSONObject.parseObject(json);
	}
}
