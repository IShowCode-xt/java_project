package com.student.controller;

import com.student.po.Admin;
import com.student.po.Student;
import com.student.po.Teacher;
import com.student.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public String  login(String username, String password,String type, Model model, HttpSession session ) {
        int typeId = Integer.valueOf(type);
        if (typeId == 0) {
            Admin admin = loginService.findAdByName(username);
            if (admin != null && admin.getPassword().equals(password)) {
                session.setAttribute("USER_SESSION", admin);
                return "redirect:afindStu.do?type=1&userSearchTxt=null";
            }
            model.addAttribute("message", "账号或密码错误");
            return "login";
        } else if (typeId == 1) {
            Teacher teacher=loginService.findTeaByName(username);
            if(teacher!=null&&teacher.getPassword().equals(password)){
                session.setAttribute("USER_SESSION",teacher);
                return "teacherInfo";
            }
            model.addAttribute("message","账号或密码错误");
            return "login";
        } else {
            Student student=loginService.findStuByName(username);
            if(student!=null&&student.getPassword().equals(password)){
                session.setAttribute("USER_SESSION",student);
                return "studentInfo";
            }
            model.addAttribute("message","账号或密码错误");
            return "login";
        }

    }
}
