package com.dreamingCourse.service.search;

import com.dreamingCourse.entity.search.SearchElastic;

import java.util.List;

public interface ElasticService {

    List<SearchElastic> findall();
    void save(List<SearchElastic> eslist);
    List<SearchElastic> searches(String keyword);
}
