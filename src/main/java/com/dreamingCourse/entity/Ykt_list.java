package com.dreamingCourse.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
@TableName("ykt_list")
public class Ykt_list {
	private int id;
	private int courseId;
	private int chapter;
	private int node;
	private String videoLink;
	private int isAlive;
	private String name;
}
