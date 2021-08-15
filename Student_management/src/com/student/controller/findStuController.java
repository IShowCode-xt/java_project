package com.student.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.po.Student;
import com.student.service.findAllStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class findStuController {
    @Autowired
    private findAllStuService findAllStuService;

    @RequestMapping(value = "findStu.do")
    public String findStu(HttpSession session, HttpServletRequest request,int type,String userSearchTxt ) {
        String username = null;
        String idcard=null;
        PageHelper.startPage(1, 10);
        List<Student> list=new ArrayList<Student>();
        if (type==1){
            list = findAllStuService.findAllStu(username,idcard);
        }else if(type==2){
             username=userSearchTxt;

           list = findAllStuService.findAllStu(username,idcard);
        }else {
        idcard=userSearchTxt;
          list = findAllStuService.findAllStu(username,idcard);
        }

        PageInfo<Student> page = new PageInfo<>(list);
        session.setAttribute("list", list);
        session.setAttribute("page", page);
        return "teacher_stuI";
    }
}