package com.dreamingCourse.service;


import com.dreamingCourse.entity.yktUser;
import com.dreamingCourse.mapper.ykt_UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

//登陆
@Service
public class Ykt_UserService {
    @Autowired
    private ykt_UserMapper ykt_userMapper;
    @Transactional
    public yktUser selectByUsername(String username, String password) {
        yktUser user = ykt_userMapper.selectByUsername(username, password);
        return user;
    }
    @Transactional
   public int insert(String username, String password,
                     String email, String phone, String question,
                     String answer, Integer role, String image,
                     String code, Date createTime, Date updateTime){

        return ykt_userMapper.insert(username, password,
                email, phone, question,
                answer, role, image,
                code, createTime, updateTime);
   }
    @Transactional
    public yktUser selectUsername(String username){
        yktUser username1=ykt_userMapper.selectUsername(username);
        return username1;
    }
    @Transactional
    public yktUser selectPhone(String phone){
        yktUser phone1=ykt_userMapper.selectUsername(phone);
        return phone1;
    }
    //查用户问题
   public yktUser selectQuestion(@Param("username") String username){
       yktUser user= ykt_userMapper.selectQuestion(username);
        return user;
   }
    //查答案
   public yktUser selectAnswer(@Param("username") String username){
       yktUser user= ykt_userMapper.selectAnswer(username);
        return user;
   }
    //改密码
   public int updateByUsername(@Param("username") String username,@Param("password") String password, @Param("updateTime") Date updateTime){
        int user=ykt_userMapper.updateByUsername(username,password,updateTime);
        return user;
    }
    public yktUser selectByCode(@Param("code") String phone){
       yktUser user= ykt_userMapper.selectByCode(phone);
       return user;
    }


}