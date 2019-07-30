package com.model;

import com.entity.Ykt_teacher;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class TeacherModel {
	private int id;
	private String tName;
	private String tDesc;
	private String tImage;
	private int courcesId;

	public TeacherModel(Ykt_teacher teacher) {
		this.id = teacher.getId();
		this.tName = teacher.getTName();
		this.tDesc = teacher.getTDesc();
		this.tImage = teacher.getTImage();
		this.courcesId = teacher.getCourcesId();
	}

	public TeacherModel() {
	}
}
