package com.student.controller;

import com.student.service.updateStuIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class updateStuInfoController {
    @Autowired
    updateStuIService updateStuIService;
    @RequestMapping("updateStuInfo.do")
    public String updateStuInfo(String stu_id,String stu_name,String stu_idC, String stu_bir,String stu_class){

int id=Integer.valueOf(stu_id);
        updateStuIService.updateStuInfo(id,stu_name,stu_idC,stu_bir,stu_class);
        return "studentInfo";
    }
}
