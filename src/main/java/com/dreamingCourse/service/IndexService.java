package com.dreamingCourse.service;

import com.dreamingCourse.entity.Course;
import com.dreamingCourse.entity.Notice;

import com.dreamingCourse.entity.SecKill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public interface IndexService {


   /* public String courseDetail(Model model,Integer id) ;*/
    List<Notice> selectNotice() ;
     List<Course> search(String mykey) ;
    List<Course> getshiCourse();
    List<Course> gethotCourse();

    List<Course> getlastCourse();
/*    List<YktSeckill> getSeckill();*/
    List<Course> gettag();
    List<SecKill> getSeckil(String data);
  /*  public String indx(Model model,HttpSession session,Course yktCourse) ;*/
/*public String befor(Model model,HttpSession session,Course yktCourse,YktSeckill yktSeckill);
    public String goodsDetail(Model model,Integer id);
    public String selectNotice(Model model);
    public String search(Model model,String mykey);*/

 /*      CatResult getItemCatList();*/
/* List<Course> getCourselist(int id);*/
}
