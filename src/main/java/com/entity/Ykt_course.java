package com.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Repository
@TableName("ykt_course")
public class Ykt_course {
	private int id;
	private int tagId;
	private String name;
	private String subtitle;
	private String mainImage;
	private String subImages;
	private String detail;
	private BigDecimal activityPrice;
	private BigDecimal price;
	private Date createTime;
	private Date updateTime;
	private int status;
	private int isAlive;
	private int teacherId;
}
