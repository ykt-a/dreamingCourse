package com.dreamingCourse.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository()
@TableName("ykt_teacher")
public class Ykt_teacher {
	private int id;
	private String tName;
	private String tDesc;
	private String tImage;
	private int courcesId;
	private int isAlive;
}
