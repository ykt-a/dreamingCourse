package com.dreamingCourse.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.net.ntp.TimeStamp;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@Repository
@TableName("ykt_seckill_goods")
@Data
public class Ykt_seckill_goods {
	private int id;
	private String name;
	private BigDecimal price;
	private BigDecimal originPrice;
	private String pic;
	private int number;
	private int startTime;
	private TimeStamp createTime;
	private int isAlive;
	private String description;
	private Date startDay;
	private int cid;
}
