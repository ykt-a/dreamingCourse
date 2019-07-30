package com.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
@TableName("ykt_user")
public class Ykt_user {
	private int id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String question;
	private String answer;
	private int role;
	private String image;
	private String code;
	private Date createTime;
	private Date updateTime;
	private int isAlive;
}
