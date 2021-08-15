package com.student.controller;

import com.student.service.delectTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class admindelectTeaController {
    @Autowired
    private delectTeaService delectTeaService;
    @RequestMapping("admindelectTea.do")
    public String delectTea(int id){
        delectTeaService.delectTea(id);
        return "redirect:afindTea.do?type=1&userSearchTxt=null";
    }
}
