package com.dreamingCourse.service.impl;

import com.dreamingCourse.entity.Course;
import com.dreamingCourse.mapper.ViewedCoursesMapper;
import com.dreamingCourse.service.ViewedCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ViewedCoursesServiceImpl implements ViewedCoursesService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ViewedCoursesMapper viewedCoursesMapper;

    @Override
    public List<Course> fviewedCourses(Integer uid) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        String key="user:"+uid+":vcourses";
        ListOperations operations=redisTemplate.opsForList();
        boolean haskey=redisTemplate.hasKey(key);
        if (haskey){
            List<Integer> list=operations.range(key,0,-1);
            System.out.println("缓存中获取>> "+list.toString());
            return viewedCoursesMapper.fviewedCourses(list);
        }
        return null;

    }

    @Override
    public void sviewedCourses(Integer uid,Integer cid) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        String key="user:"+uid+":vcourses";
        ListOperations operations=redisTemplate.opsForList();
        boolean haskey=redisTemplate.hasKey(key);
        if (!haskey){
            operations.rightPush(key,cid);
            return;
        }
        List<Integer> list=operations.range(key,0,-1);
        if (operations.size(key)<5){

            for (int i = 0; i <list.size() ; i++) {
                if (list.get(i)==cid){
                    operations.remove(key,0,cid);
                    break;
                }
            }
            operations.rightPush(key,cid);
        }
        if (operations.size(key)>=5){
            for (int i = 0; i <list.size() ; i++) {
                if (list.get(i)==cid){
                    operations.remove(key,0,cid);
                    break;
                }
            }
            if (operations.size(key)>=5){
                operations.leftPop(key);
                operations.rightPush(key,cid);
            }else {
                operations.rightPush(key,cid);
            }

        }

    }
}
