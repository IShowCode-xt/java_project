package com.student.controller;

import com.student.service.delectScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class teadelectScoreController {
    @Autowired
    private delectScoreService delectScoreService;
    @RequestMapping("teadelectScore.do")
    public String delectScore(String stuCard){
        delectScoreService.delectScore(stuCard);
        return "redirect:findScore.do?type=1&userSearchTxt=null";
    }
}
