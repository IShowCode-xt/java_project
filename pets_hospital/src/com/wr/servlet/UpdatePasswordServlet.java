package com.wr.servlet;

import com.wr.bean.User;
import com.wr.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String message=null;
        String url=null;
        //User user=(User)request.getAttribute("user");
        User user=(User)request.getSession().getAttribute("user");
        String oldPassword=request.getParameter("oldPassword");
        String newPassword1=request.getParameter("newPassword1");
        String newPassword2=request.getParameter("newPassword2");
        UserDao userDao=new UserDao();
        if(!oldPassword.equals(user.getPassword())){
            message="旧密码输入错误";
            return;
        }
        if (!newPassword1.equals(newPassword2)){
            message="密码输入不一致";
            return;
        }

        boolean result= userDao.updatePassword(user.getName(),newPassword1);;

        if (!result){
            message="密码修改失败";
            return;
        }
        message="修改密码成功，请重新登录";
        request.setAttribute("message",message);
        request.getSession(true).invalidate();
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
