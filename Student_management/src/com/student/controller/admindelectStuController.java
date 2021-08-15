package com.student.controller;

import com.student.service.delectStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class admindelectStuController {
    @Autowired
    private delectStuService delectStuService;
    @RequestMapping("admindelectStu.do")
    public String delectStu(int id){
        delectStuService.delectStu(id);
        return "redirect:afindStu.do?type=1&userSearchTxt=null";
    }
}
