package com.student.controller;

import com.student.service.addStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class adminaddStuController {

    @Autowired
    private addStuService addStuService;
    @RequestMapping("AdminaddStu.do")
    public String addstu(String username,String idcard,String birthdate,String classId,String password){
        int rows =addStuService.addStu(username,idcard,birthdate,classId,password);
        return "redirect:afindStu.do?type=1&userSearchTxt=null";
    }
}
