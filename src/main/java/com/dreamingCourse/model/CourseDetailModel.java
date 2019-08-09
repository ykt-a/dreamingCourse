package com.dreamingCourse.model;


import com.dreamingCourse.dao.TagDao;
import com.dreamingCourse.entity.Ykt_course;
import com.dreamingCourse.entity.Ykt_teacher;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Data
@Repository
public class CourseDetailModel {
	private String name;
	private String subtitle;
	private String mainImage;
	private String subImages;
	private String detail;
	private BigDecimal activityPrice;
	private BigDecimal price;
	private String tagName;
	private String isBuy;
	private String tName;
	private String tDesc;
	private String tImage;

	public void init(Ykt_course course, Ykt_teacher teacher, TagDao tagDao) {
		this.name = course.getName();
		this.subtitle = course.getSubtitle();
		this.mainImage = course.getMainImage();
		this.subImages = course.getSubImages();
		this.detail = course.getDetail();
		this.activityPrice = course.getActivityPrice();
		this.price = course.getPrice();
		this.tagName = tagDao.getTagNameById(course.getId());
		this.tName = teacher.getTName();
		this.tDesc = teacher.getTDesc();
		this.tImage = teacher.getTImage();
	}
}
