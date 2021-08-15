package com.student.controller;

import com.student.dao.TeaFindStuDaoAll;
import com.student.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeaFindStuControllerAll {
    @Autowired
    private TeaFindStuDaoAll teaFindStuDaoAll;
@RequestMapping("TeaFindStuController.do")
    public List<Student> teaFindStu(int classId){
    teaFindStuDaoAll.TeaFindStuDaoAll(classId);
    return null;
}
}
