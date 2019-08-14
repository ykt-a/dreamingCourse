package com.dreamingCourse.mapper;

import com.dreamingCourse.entity.yktUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;

@Mapper
@Component
public interface ykt_UserMapper {
    //用户登陆
    yktUser selectByUsername(@Param("username") String username, @Param("password") String password);
    int deleteByPrimaryKey(Integer id);
    //用户注册
    int insert(@Param("username") String username, @Param("password") String password,
               @Param("email") String email, @Param("phone") String phone, @Param("question") String question,
               @Param("answer") String answer, @Param("role") Integer role, @Param("image") String image,
               @Param("code") String code, @Param("createTime") Date createTime, @Param("updateTime") Date updateTime);
    //注册用户名是否存在验证
    yktUser selectUsername(@Param("username") String username);
    //注册电话号码是否注册过验证
    yktUser selectPhone(@Param("phone") String phone);
    //查用户的问题
    yktUser selectQuestion(@Param("username") String username);
    //查答案
    yktUser selectAnswer(@Param("username") String username);
    //改密码
    int updateByUsername(@Param("username") String username, @Param("password") String password, @Param("updateTime") Date updateTime);
    //短信验证
    yktUser selectByCode(@Param("phone") String phone);

    int insertSelective(yktUser record);

    yktUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(yktUser record);

    int updateByPrimaryKey(yktUser record);
}