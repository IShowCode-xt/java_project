package com.student.controller;

import com.student.service.updateStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class teaUpdateStuController {
    @Autowired
    private updateStuService updateStuService;
    @RequestMapping("teaupdateStu.do")
    public String updateStu(String username,String idcard,String birthdate,String classId,String password,int id){
        int rows=updateStuService.updateStu(username,idcard,birthdate,classId,password,id);
        return "redirect:findStu.do?type=1&userSearchTxt=null";
    }
}
