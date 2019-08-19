package com.dreamingCourse.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dreamingCourse.dao.*;
import com.dreamingCourse.entity.Ykt_assess;
import com.dreamingCourse.entity.Ykt_list;
import com.dreamingCourse.entity.Ykt_teacher;
import com.dreamingCourse.model.AssessModel;
import com.dreamingCourse.model.ChapterModel;
import com.dreamingCourse.model.CourseDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
		if (courseDao.getById(courseId)==null||courseDao.getById(courseId).getIsAlive() == 0) {
			return null;
		}
		//判断用户是否已购买此课程
		if (userId == null) {
			courseDetailModel.setIsBuy(false);
		} else {
			List<String> coursesId = userDao.getCourseListByUid(userId.intValue());
			if (coursesId.contains(String.valueOf(courseId))) {
				courseDetailModel.setIsBuy(true);
			} else courseDetailModel.setIsBuy(false);
		}
		//int teacherId = courseDao.getById(courseId).getTeacherId();
		int teacherId = 0;
		try {
			teacherId = teacherDao.getByCourseId(courseId).getId();
		} catch (NullPointerException e) {
			//课程存在但对应的老师不存在
			return null;
		}
		Ykt_teacher teacher = teacherDao.getById(teacherId);
		if (courseDetailModel.getIsBuy().equals(false)){
			courseDetailModel.init(courseDao.getById(courseId), teacher, tagDao);
		}else {
			courseDetailModel.initAll(courseDao.getById(courseId), teacher, tagDao, listDao);
		}
		return courseDetailModel;
	}

	/*
	 * 获取课程全部的章节，包括视频链接
	 * */
	public List<ChapterModel> getFullChapterByCourseId(int id) {
		List<ChapterModel> chapterModels = new ArrayList<>();
		List<Ykt_list> list = listDao.getByCourseId(id);
		for (Ykt_list temp : list) {
			chapterModels.add(ChapterModel.initAll(temp));
		}
		sortForChaperModels(chapterModels);
		return chapterModels;
	}

	private void sortForChaperModels(List<ChapterModel> chapterModels) {
		Collections.sort(chapterModels, new Comparator<ChapterModel>() {
			@Override
			public int compare(ChapterModel o1, ChapterModel o2) {
				if (o1.getChapter() > o2.getChapter()) {
					return 1;
				} else if (o1.getChapter() == o2.getChapter()) {
					return o1.getNode() > o2.getNode() ? 1 : (o1.getNode() == o2.getNode() ? 0 : -1);
				} else  {
					return -1;
				}
			}
		});
	}

	/*
	 * 未购买课程的用户只能获得章节标题，没有视频链接
	 * */
	public List<ChapterModel> getChapterByCourseId(int id) {
		List<ChapterModel> chapterModels = new ArrayList<>();
		List<Ykt_list> list = listDao.getByCourseId(id);
		for (Ykt_list temp : list) {
			chapterModels.add(ChapterModel.init(temp));
		}
		sortForChaperModels(chapterModels);
		return chapterModels;
	}

	/*
	 * 获取课程的评价
	 * */
	public Map<String, Object> getCourseAssessByCourseId(int id, int pagecount) {
		Map<String, Object> map = new HashMap<>();
		Page page = assessDao.getListPageByCourseId(id, pagecount);
		List<Ykt_assess> list = page.getRecords();
		List<AssessModel> assessModels = new ArrayList<>();
		for (Ykt_assess temp : list) {
			assessModels.add(AssessModel.init(temp));
		}
		map.put("data", assessModels);
		map.put("hasNextPage", page.hasNext());
		return map;
	}
}
