package com.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
@TableName("ytk_aeesee")
public class Ykt_assess{
	private int id;
	private int orderId;
	private int courseId;
	private String desc;
	private int stars;
	private Date createTime;
	private int isAlive;
}
