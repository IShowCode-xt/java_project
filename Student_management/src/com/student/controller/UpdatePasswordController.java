package com.student.controller;

import com.student.service.updatePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UpdatePasswordController {
    @Autowired
    private updatePasswordService updatePasswordService;
    @RequestMapping("updateStupassword.do" )
    public String updateStupassword(String id, String newPassword2, Model model, HttpSession session){
        int sid=Integer.valueOf(id);
     updatePasswordService.updateStuPassword(sid,newPassword2);
        String message="修改成功!";
        model.addAttribute("message",message);
        session.invalidate();
        return "login";
    };
    @RequestMapping("updateAdminpassword.do" )
    public String updateAdminpassword(String id, String newPassword2, Model model, HttpSession session){
        int sid=Integer.valueOf(id);
        updatePasswordService.updateAdminPassword(sid,newPassword2);
        String message="修改成功!";
        model.addAttribute("message",message);
        session.invalidate();
        return "login";
    };
    @RequestMapping("updateTeapassword.do" )
    public String updateTeapassword(String id, String newPassword2, Model model, HttpSession session){
        int sid=Integer.valueOf(id);
        updatePasswordService.updateTeaPassword(sid,newPassword2);
        String message="修改成功!";
        model.addAttribute("message",message);
        session.invalidate();
        return "login";
    };
}
