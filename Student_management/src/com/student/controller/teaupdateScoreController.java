package com.student.controller;

import com.student.service.updateScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class teaupdateScoreController {
    @Autowired
    private updateScoreService updateScoreService;
    @RequestMapping("teaupdateScore.do")
    public String updateScore(String username,String stuCard,int javaw,int javaee,int vue,int russion){
        int rows=updateScoreService.updateScore(username,stuCard,javaw,javaee,vue,russion);
        return "redirect:findScore.do?type=1&userSearchTxt=null";
    }
}
