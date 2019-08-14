package com.dreamingCourse.service.impl;


import com.dreamingCourse.entity.Course;
import com.dreamingCourse.entity.Notice;
import com.dreamingCourse.entity.SecKill;

import com.dreamingCourse.mapper.Indexmapper;

import com.dreamingCourse.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/*import com.dreamingCourse.mapper.YktCourseMapper;*/

@Service("indexService")

public class IndexServiceimp implements IndexService {
  @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

/*  @Resource
    private ValueOperations<String,Object> valueOperations;*/

   /* @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;*/

/*    @Resource
    private RedisService redisService;*/
    @Autowired
    private Indexmapper indexmapper;



    @Override
    public List<Notice> selectNotice() {

        return indexmapper.selectnotice();
    }

    @Override
    public List<Course> search(String mykey) {

        return indexmapper.search(mykey);
    }

    @Override
    public List<Course> getshiCourse() {
        java.util.Date t=new java.util.Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String data=df.format(t);
        String redisKey="shilist"+data;
        ListOperations<String, Course> shilist= redisTemplate.opsForList();
        if (redisTemplate.hasKey(redisKey)){
            System.out.println("-----------------从缓存--------");
            List list=shilist.range(redisKey,0,-1);
         return list;
        }else{
            List<Course> list = indexmapper.getshiCourse();
            /*  listOperations.leftPush("list:course",list);*/
            for (Course yc : list) {
                shilist.rightPush(redisKey, yc);
            }
            return list;
        }

    }

   /* @Autowired
    private ListOperations<String, Object> listOperations;*/

    @Override
    public List<Course> gethotCourse() {
        java.util.Date t=new java.util.Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String data=df.format(t);
        String redisKey="hotlist"+data;
        ListOperations<String, Course> hotlist= redisTemplate.opsForList();
        if (redisTemplate.hasKey(redisKey)){
            System.out.println("---------------从缓存----------");
            List list=hotlist.range(redisKey,0,-1);

            return list;
        }else {

            List<Course> list = indexmapper.gethotCourse();
            /*  listOperations.leftPush("list:course",list);*/
            for (Course yc : list) {
                hotlist.rightPush(redisKey, yc);
            }
            System.out.println("从数据库");

            return list;
        }
    }


    @Override
    public List<Course> getlastCourse() {
        java.util.Date t=new java.util.Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String data=df.format(t);
        String redidsKey="lastlist"+data;
        ListOperations<String, Course> lastlist= redisTemplate.opsForList();
        if (redisTemplate.hasKey(redidsKey)){
            System.out.println("---------------从缓存----------");
            List list=lastlist.range(redidsKey,0,-1);

            return list;
        }else {
            List<Course> list = indexmapper.getlastCourse();
            for (Course yc : list) {
                lastlist.rightPush(redidsKey, yc);
            }
            return list;
        }
        /*return indexmapper.getlastCourse();*/
    }


    @Override
    public List<Course> gettag() {

        return indexmapper.gettag();
    }

    @Override
    public List<SecKill> getSeckil(String data) {

        String rediskey="seckillist"+data;
        ListOperations<String, SecKill> seckillist= redisTemplate.opsForList();
        if (redisTemplate.hasKey(rediskey))
        {
         List list=seckillist.range(rediskey,0,-1);

            System.out.println("从缓存中获取》");
            return list;
        }else {
            List<SecKill> list = indexmapper.getSeckil(data);
            for (SecKill ys : list) {
                seckillist.rightPush(rediskey, ys);
            }
            System.out.println("从mysql中获取》" );
            return list;
        }
     /*return indexmapper.getSeckil(data);*/
    }


/*        Goods goods = indexDao.selectGoodsById(id);
        model.addAttribute("goods", goods);*//*

        return "before/goodsdetail";
    }

    @Override
    public String selectNotice(Model model) {
     model.addAttribute("notice",indexmapper.selectnotice());
        return "noticeDetail";
    }

    @Override
    public String search(Model model, String mykey) {
        List<Course> list=indexmapper.search(mykey);
        model.addAttribute("search",list);
        return "searchResult";
    }
*/




 /*   @Override
    public String indx(Model model,HttpSession session,Course yktCourse) {
     model.addAttribute("lastedlist",indexmapper.getlastCourse(yktCourse));
        return "indx/index";
    }
*/

}