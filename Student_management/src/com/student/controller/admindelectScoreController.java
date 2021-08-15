package com.student.controller;

import com.student.service.delectScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class admindelectScoreController {
    @Autowired
    private delectScoreService delectScoreService;
    @RequestMapping("admindelectScore.do")
    public String delectScore(String stuCard){
        delectScoreService.delectScore(stuCard);
        return "redirect:afindScore.do?type=1&userSearchTxt=null";
    }
}
