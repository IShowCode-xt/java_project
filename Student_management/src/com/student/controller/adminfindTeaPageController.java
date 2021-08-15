package com.student.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.po.Teacher;
import com.student.service.findTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class adminfindTeaPageController {
    @Autowired
    private com.student.service.findTeaService findTeaService;
    @RequestMapping("afindTeaPage.do")
    public String findTea(HttpSession session, HttpServletRequest request, int type, String userSearchTxt ,int pageNumber) {
        String username = null;
        String idcard=null;
        PageHelper.startPage(pageNumber, 10);
        List<Teacher> list=new ArrayList<Teacher>();
        if (type==1){
            list = findTeaService.findTea(username,idcard);
        }else if(type==2){
            username=userSearchTxt;

            list = findTeaService.findTea(username,idcard);
        }else {
            idcard=userSearchTxt;
            list =findTeaService.findTea(username,idcard);
        }

        PageInfo<Teacher> page = new PageInfo<>(list);
        session.setAttribute("list", list);
        session.setAttribute("page", page);
        return "admin_teaI";
    }
}
