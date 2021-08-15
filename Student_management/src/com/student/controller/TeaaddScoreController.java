package com.student.controller;

import com.student.service.addScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeaaddScoreController {
    @Autowired
    private addScoreService addScoreService;
    @RequestMapping("TeaaddScore.do")
    public String addScore(String username,String stucard,int javaw ,int javaee,int vue,int russion){
        int rows=addScoreService.addScore(username,stucard,javaw,javaee,vue,russion);
        return "redirect:findScore.do?type=1&userSearchTxt=null";
    }
}
