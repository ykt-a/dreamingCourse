package com.dreamingCourse.controller;

import com.dreamingCourse.service.impl.FpcoursesServieImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    FpcoursesServieImp fpcoursesServieImp;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        Integer id=1;
        fpcoursesServieImp.findpcouses(id);

        return "Hello";
    }
}
