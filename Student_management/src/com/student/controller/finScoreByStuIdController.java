package com.student.controller;

import com.student.po.Score;
import com.student.service.findScoreByStuIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class finScoreByStuIdController {
    @Autowired
    private findScoreByStuIdService findScoreByStuIdService;
    @RequestMapping("findScoreByStuId.do")
    public String findScoreByStuId (String stuCard, HttpSession session){
    Score score=findScoreByStuIdService.findScoreByStuId(stuCard);
    session.setAttribute("sco",score);
    return "AdminupdateStuS";
    }
    @RequestMapping("stufindScoreByStuId.do")
    public String findScoreByStuId2 (String stuCard, HttpSession session){
        Score score=findScoreByStuIdService.findScoreByStuId(stuCard);
        session.setAttribute("sco",score);
        return "studentScore";
    }
}
