package com.student.controller;

import com.student.po.Teacher;
import com.student.service.findTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class adminfindTeaById {
    @Autowired
    private findTeaService findTeaService;
    @RequestMapping("AdminfindTeaById.do")
    public String findTeaById(int id, HttpSession session){
        Teacher teacher=findTeaService.findTeacherById(id);
        session.setAttribute("tea",teacher);
        return "AdminupdateTeaI";
    }
}
