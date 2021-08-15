package com.student.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.po.Student;
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
public class adminfindTeaController {
    @Autowired
    private findTeaService findTeaService;
    @RequestMapping("afindTea.do")
    public String findTea(HttpSession session, HttpServletRequest request, int type, String userSearchTxt ) {
        String username = null;
        String classId=null;
        PageHelper.startPage(1, 10);
        List<Teacher> list=new ArrayList<Teacher>();
        if (type==1){
            list = findTeaService.findTea(username,classId);
        }else if(type==2){
            username=userSearchTxt;

            list = findTeaService.findTea(username,classId);
        }else {
            classId=userSearchTxt;
            list =findTeaService.findTea(username,classId);
        }

        PageInfo<Teacher> page = new PageInfo<>(list);
        session.setAttribute("list", list);
        session.setAttribute("page", page);
        return "admin_teaI";
    }
}
