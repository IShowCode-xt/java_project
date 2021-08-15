package com.student.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.po.Score;
import com.student.service.findScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class findScorePageController {
    @Autowired
    private findScoreService findScoreService;

    @RequestMapping(value = "findScorePage.do")
    public String findStu(HttpSession session, int type, String userSearchTxt, int pageNumber) {
        String username = null;
        String idcard = null;
        PageHelper.startPage(pageNumber, 10);
        List<Score> list = new ArrayList<Score>();
        if (type == 1) {
            list = findScoreService.findScore(username, idcard);
        } else if (type == 2) {
            username = userSearchTxt;

            list = findScoreService.findScore(username, idcard);
        } else {
            idcard = userSearchTxt;
            list = findScoreService.findScore(username, idcard);
        }

        PageInfo<Score> page = new PageInfo<>(list);
        session.setAttribute("list", list);
        session.setAttribute("page", page);
        return "teacher_stuS";
    }
}