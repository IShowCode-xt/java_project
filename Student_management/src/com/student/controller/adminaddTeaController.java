package com.student.controller;

import com.student.service.addStuService;
import com.student.service.addTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class adminaddTeaController {

    @Autowired
    private addTeaService addTeaService;
    @RequestMapping("AdminaddTea.do")
    public String addstu(String username,String classId,String password){
        int rows =addTeaService.addTea(username,classId,password);
        return "redirect:afindTea.do?type=1&userSearchTxt=null";
    }
}
