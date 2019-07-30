package com.dao;


import com.entity.Ykt_list;
import com.mapper.ListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListDao {
	@Autowired
	ListMapper listMapper;

	public List<Ykt_list> getList(){
		return listMapper.selectList(null);
	}

	public Ykt_list getById(int i){
		return listMapper.selectById(i);
	}
}
