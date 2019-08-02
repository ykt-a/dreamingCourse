package com.model;

import com.entity.Ykt_teacher;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class TeacherModel {
	private int id;
	private String tName;
	private String tDesc;
	private String tImage;

	@Autowired
	public TeacherModel(Ykt_teacher teacher) {
		this.id = teacher.getId();
		this.tName = teacher.getTName();
		this.tDesc = teacher.getTDesc();
		this.tImage = teacher.getTImage();

	}

	public TeacherModel() {
	}
}
