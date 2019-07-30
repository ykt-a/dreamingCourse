package com.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
@TableName("ykt_tag")
public class Ykt_tag {
	private int id;
	private int courseId;
	private int parentId;
	private String name;
	private int isHot;
	private Date createTime;
	private Date updateTime;
	private int isAlive;
}
