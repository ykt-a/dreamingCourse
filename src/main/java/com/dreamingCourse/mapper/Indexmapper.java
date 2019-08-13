//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dreamingCourse.mapper;

import com.dreamingCourse.entity.Course;
import com.dreamingCourse.entity.Notice;
import com.dreamingCourse.entity.SecKill;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface Indexmapper {

   List<Course> search(@Param("mykey") String var1);

    List<Course> getlastCourse();//最新上新
 /*List<Map<String,Object>> getlastCourse(Course yktCourse);*/
    List<Course> gethotCourse();//课程推荐
    List<Notice> selectnotice();//公告
    List<Course> getshiCourse();//实战课程推荐
   /* List<YktSeckill> getSeckill();//秒杀课程*/
    List<Course>  gettag();//分类
    /*List<YktSeckill> getSeckil(Integer pageNo)*/;//秒杀课程
    List<SecKill> getSeckil(String data2);
}
