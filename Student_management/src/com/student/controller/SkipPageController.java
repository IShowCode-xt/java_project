package com.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SkipPageController {
    @RequestMapping("studentInfo.do")
    public String skipPage1(){
        return "studentInfo";
    }
    @RequestMapping("studentScore.do")
    public String skipPage2(){
        return "studentScore";
    }
    @RequestMapping("update_password_stu.do")
    public String skipPage11(){
        return "update_password_stu";
    }
    @RequestMapping("teacherInfo.do")
    public String skipPage3(){
        return "teacherInfo";
    }
    @RequestMapping("teacher_stuI.do")
    public String skipPage4(){
        return "teacher_stuI";
    }
    @RequestMapping("teacher_stuS.do")
    public String skipPage5(){
        return "teacher_stuS";
    }
    @RequestMapping("teacher_addstuI.do")
    public String skipPage9(){
        return "teacher_addstuI";
    }
    @RequestMapping("teacher_addstuS.do")
    public String skipPage10(){
        return "teacher_addstuS";
    }
    @RequestMapping("update_password_tea.do")
    public String skipPage12(){
        return "update_password_tea";
    }
    @RequestMapping("admin_stuI.do")
    public String skipPage6(){
        return "admin_stuI";
    }
    @RequestMapping("admin_stuS.do")
    public String skipPage7(){
        return "admin_stuS";
    }
    @RequestMapping("admin_teaI.do")
    public String skipPage8(){
        return "admin_teaI";
    }
    @RequestMapping("update_password_ad.do")
    public String skipPage13(){
        return "update_password_ad";
    }
    @RequestMapping("AdminupdateStuI.do")
    public String skipPage14(){
        return "AdminupdateStuI";
    }
    @RequestMapping("AdminupdateStuS.do")
    public String skipPage15(){
        return "AdminupdateStuS";
    }
    @RequestMapping("AdminupdateTeaI.do")
    public String skipPage16(){
        return "AdminupdateTeaI";
    }
    @RequestMapping("admin_addstuI.do")
    public String skipPage17(){
        return "admin_addstuI";
    }
    @RequestMapping("admin_addstuS.do")
    public String skipPage18(){
        return "admin_addstuS";
    }
    @RequestMapping("admin_addteaI.do")
    public String skipPage19(){
        return "admin_addteaI";
    }
    @RequestMapping("updateStuI.do")
    public String skipPage20(){
        return "updateStuI";
    }
    @RequestMapping("updateStuS.do")
    public String skipPage21(){
        return "updateStuS";
    }
    @RequestMapping("logins.do")
    public String skipPage22(){
        return "login";
    }

}
