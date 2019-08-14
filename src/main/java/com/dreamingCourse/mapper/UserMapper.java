package com.dreamingCourse.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dreamingCourse.entity.User;
import com.dreamingCourse.entity.Ykt_user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<Ykt_user> {
    User deleteByPrimaryKey(Integer id);

    User insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    User updateByPrimaryKey(User record);

    User findByInfo(String username, String password);
}
