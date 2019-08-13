package com.dreamingCourse.mapper.search;

import com.dreamingCourse.entity.search.SearchElastic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElasticMapper {
    List<SearchElastic> findall();
}
