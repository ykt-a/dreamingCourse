package com.dreamingCourse.controller;

import com.dreamingCourse.entity.Course;
import com.dreamingCourse.service.impl.FpcoursesServieImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class PdcoursesController {
    @Autowired
    FpcoursesServieImp fpcoursesServieImp;

    @RequestMapping("/findpcouses")
    public @ResponseBody List<Course> findpcouses(Integer id){
        id=1;
       return fpcoursesServieImp.findpcouses(id);
    }
}
