package com.model;


import com.dao.TagDao;
import com.entity.Ykt_course;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

@Repository
@Data
public class CourseModel {
	private int id;
	private String tagName;
	private String name;
	private String subtitle;
	private String mainImage;
	private String subImages;
	private String detail;
	private BigDecimal activityPrice;
	private BigDecimal price;
	private String createTime;
	private String updateTime;

	public CourseModel() {
	}

	public CourseModel init(Ykt_course course, TagDao tagDao) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CourseModel courseModel = new CourseModel();
		courseModel.setId(course.getId());
		courseModel.setName(course.getName());
		courseModel.setSubtitle(course.getSubtitle());
		courseModel.setMainImage(course.getMainImage());
		courseModel.setSubImages(course.getSubImages());
		courseModel.setDetail(course.getDetail());
		courseModel.setActivityPrice(course.getActivityPrice());
		courseModel.setPrice(course.getPrice());
		courseModel.setCreateTime(simpleDateFormat.format(course.getCreateTime()));
		courseModel.setUpdateTime(simpleDateFormat.format(course.getUpdateTime()));
		courseModel.setTagName(tagDao.getTagNameById(course.getTagId()));
		return courseModel;
	}
}
