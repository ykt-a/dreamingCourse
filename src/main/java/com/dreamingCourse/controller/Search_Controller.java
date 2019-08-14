package com.dreamingCourse.controller;

/*package com.dreamingCourse.controller.search;
import com.dreamingCourse.entity.search.SearchElastic;
import com.dreamingCourse.service.search.ElasticService;*/

import com.dreamingCourse.entity.SearchElastic;
import com.dreamingCourse.service.ElasticService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Search_Controller extends HttpServlet {

    @Autowired
    private ElasticService elasticService;

    //mysql数据同步es
    @RequestMapping("/save")
    @ResponseBody
    public String findall() {
        List<SearchElastic> searchElastics = elasticService.findall();
        List<SearchElastic> addList = new ArrayList<SearchElastic>();
        for(SearchElastic  searchElastic : searchElastics){
            SearchElastic newEntity = new SearchElastic(searchElastic.getId(),searchElastic.getName(),searchElastic.getSubtitle(),searchElastic.getDetail(),searchElastic.getMain_images(),searchElastic.getPrice(),searchElastic.getTag_id());
            addList.add(newEntity);
        }
        elasticService.save(addList);
        return "";
    }
    @RequestMapping(value="/search", method= RequestMethod.GET)
    @ResponseBody
    public List<SearchElastic> save(String name) {
        List<SearchElastic> entityList = null;
        if(StringUtils.isNotEmpty(name)) {
            entityList = elasticService.searches(name);
        }
        return entityList;
    }
}