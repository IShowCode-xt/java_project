package com.student.controller;

import com.student.service.findTeaService;
import com.student.service.updateTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeaupdateInfoController {
    @Autowired
    private updateTeaService updateTeaService;
    @RequestMapping("teaupdateInfo.do")
    public String updateInfo(String username,String classId,String password,int id){
        updateTeaService.updateTea(username,classId,password,id);
        return "teacherInfo";
    }
}
