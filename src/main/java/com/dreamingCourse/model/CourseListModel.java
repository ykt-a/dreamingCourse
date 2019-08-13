package com.dreamingCourse.model;


import com.dreamingCourse.dao.TagDao;
import com.dreamingCourse.entity.Ykt_course;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
@Data
public class CourseListModel {
	private int id;
	private String tagName;
	private String name;
	private String subtitle;
	private String mainImage;
	private String subImages;
	private String detail;
	private BigDecimal activityPrice;
	private BigDecimal price;

	public CourseListModel() {
	}

	public CourseListModel init(Ykt_course course, TagDao tagDao) {
		CourseListModel courseListModel = new CourseListModel();
		courseListModel.setId(course.getId());
		courseListModel.setName(course.getName());
		courseListModel.setSubtitle(course.getSubtitle());
		courseListModel.setMainImage(course.getMainImage());
		courseListModel.setSubImages(course.getSubImages());
		courseListModel.setDetail(course.getDetail());
		courseListModel.setActivityPrice(course.getActivityPrice());
		courseListModel.setPrice(course.getPrice());
		courseListModel.setTagName(tagDao.getTagNameById(course.getTagId()));
		return courseListModel;
	}
}
