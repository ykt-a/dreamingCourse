package com.dao;


import com.entity.Ykt_list;
import com.entity.Ykt_user;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDao {

	@Autowired
	UserMapper userMapper;

	public List<Ykt_user> getList() {
		return userMapper.selectList(null);
	}

	public Ykt_user getById(int i) {
		return userMapper.selectById(i);
	}

	public List<String> getCourseListByUid(int id) {
		String string = userMapper.selectById(id).getCourseId();
		return Arrays.asList(string.split("-"));
	}
}
