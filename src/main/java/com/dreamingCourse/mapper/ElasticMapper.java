package com.dreamingCourse.mapper;

import com.dreamingCourse.entity.SearchElastic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElasticMapper {
    List<SearchElastic> findall();
}
