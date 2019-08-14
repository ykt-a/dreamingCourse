package com.dreamingCourse.service;

import com.dreamingCourse.entity.SearchElastic;

import java.util.List;

public interface ElasticService {

    List<SearchElastic> findall();
    void save(List<SearchElastic> eslist);
    List<SearchElastic> searches(String keyword);
}
