package com.student.controller;

import com.student.service.findTeaService;
import com.student.service.updateTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class adminUpdateTeaController {
    @Autowired
    private updateTeaService updateTeaService;
    @RequestMapping("adminupdateTea.do")
    public String updateTea(String username,String classId,String password,int id){
        int rows=updateTeaService.updateTea(username,classId,password,id);
        return "redirect:afindTea.do?type=1&userSearchTxt=null";
    }
}
