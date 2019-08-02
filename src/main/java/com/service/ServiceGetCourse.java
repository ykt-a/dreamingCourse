package com.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dao.*;
import com.entity.Ykt_assess;
import com.entity.Ykt_list;
import com.entity.Ykt_teacher;
import com.model.AssessModel;
import com.model.ChapterModel;
import com.model.CourseDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceGetCourse {

	@Autowired
	CourseDetailModel courseDetailModel;

	@Autowired
	ChapterModel chapterModel;

	@Autowired
	CourseDao courseDao;

	@Autowired
	UserDao userDao;

	@Autowired
	TeacherDao teacherDao;

	@Autowired
	TagDao tagDao;

	@Autowired
	ListDao listDao;

	@Autowired
	AssessDao assessDao;
	/*
	* 根据用户id和课程id查询课程详情
	* */
	public CourseDetailModel getCourseDetailById(Integer userId, int courseId) {
		//查询课程是否存活
		if (courseDao.getById(courseId).getIsAlive()==0){
			return null;
		}
		//判断用户是否已购买此课程
		if (userId == null) {
			courseDetailModel.setIsBuy("false");
		} else {
			List<String> coursesId = userDao.getCourseListByUid(userId.intValue());
			if (coursesId.contains(String.valueOf(courseId))) {
				courseDetailModel.setIsBuy("true");
			} else courseDetailModel.setIsBuy("false");
		}
		int teacherId = courseDao.getById(courseId).getTeacherId();

		Ykt_teacher teacher = teacherDao.getById(teacherId);
		courseDetailModel.init(courseDao.getById(courseId), teacher, tagDao);

		return courseDetailModel;
	}

	/*
	* 获取课程全部的章节，包括视频链接
	* */
	public List<ChapterModel> getFullChapterByCourseId(int id){
		List<ChapterModel> chapterModels = new ArrayList<>();
		List<Ykt_list> list = listDao.getByCourseId(id);
		for (Ykt_list temp : list){
			chapterModels.add(ChapterModel.initAll(temp));
		}
		return chapterModels;
	}

	/*
	* 未购买课程的用户只能获得章节标题，没有视频链接
	* */
	public List<ChapterModel> getChapterByCourseId(int id){
		List<ChapterModel> chapterModels = new ArrayList<>();
		List<Ykt_list> list = listDao.getByCourseId(id);
		for (Ykt_list temp : list){
			chapterModels.add(ChapterModel.init(temp));
		}
		return chapterModels;
	}

	/*
	* 获取课程的评价
	* */
	public Map<String,Object> getCourseAssessByCourseId(int id,int pagecount){
		Map<String,Object> map = new HashMap<>();
		Page page = assessDao.getListPageByCourseId(id, pagecount);
		List<Ykt_assess> list = page.getRecords();
		List<AssessModel> assessModels = new ArrayList<>();
		for (Ykt_assess temp : list){
			assessModels.add(AssessModel.init(temp));
		}
		map.put("data", assessModels);
		map.put("hasNextPage", page.hasNext());
		return map;
	}
}
