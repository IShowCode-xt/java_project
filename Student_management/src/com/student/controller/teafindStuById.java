package com.student.controller;

import com.student.po.Student;
import com.student.service.findAllStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class teafindStuById {
    @Autowired
    private findAllStuService findAllStuService;
    @RequestMapping("teafindStuById.do")
    public  String findStuById(int id, HttpSession session){
        Student student=findAllStuService.findStudent(id);
        session.setAttribute("stu",student);
        return "updateStuI";
    }
}
