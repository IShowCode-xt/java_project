package com.student.controller;

import com.student.service.teaupdateinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class teaupdateInfoFormeController {
    @Autowired
    private teaupdateinService teaupdateinService;
    @RequestMapping("teaupdate.do")
    public String teaupdate(int id,String username,String classId){
      int rows=  teaupdateinService.updateIn(id,username,classId);
        return "teacherInfo";
    }

}
