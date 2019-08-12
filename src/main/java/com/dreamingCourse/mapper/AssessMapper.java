package com.dreamingCourse.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dreamingCourse.entity.Assess;
import com.dreamingCourse.entity.Ykt_assess;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssessMapper extends BaseMapper<Ykt_assess> {
    Assess deleteByPrimaryKey(Integer id);

    Assess insert(Assess record);

    Assess selectByPrimaryKey(Integer id);

    List<Assess> selectAll();

    Assess updateByPrimaryKey(Assess record);
}