package com.dreamingCourse.service.impl;

import com.dreamingCourse.entity.Course;
import com.dreamingCourse.mapper.PdcoursesMapper;
import com.dreamingCourse.service.FpcourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FpcoursesServieImp implements FpcourseService {


    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private PdcoursesMapper pdcoursesMapper;


    public List<Course> findpcouses(Integer id) {

        redisTemplate.setKeySerializer(new StringRedisSerializer());

        String key = "user:" + id+":pcourses";
        ListOperations<String, Course> operations = redisTemplate.opsForList();

        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {

            List list=operations.range(key,0,-1);

            System.out.println("缓存中获取>> " + list.toString());
            return list;
        }
        List<Course> list=pdcoursesMapper.findpcourses(id);
        for (Course yc:list) {
            operations.rightPush(key,yc);
        }

        System.out.println("mysql中获取>> " + list.toString());

        return list;
    }
}
