package com.dreamingCourse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dreamingCourse.entity.Ykt_user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<Ykt_user> {
}
