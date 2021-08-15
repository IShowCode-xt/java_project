package com.wr.servlet;

import com.wr.bean.User;
import com.wr.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String message=null;
        String url=null;
        String username=req.getParameter("username");
        String password=req.getParameter("pwd");
        UserDao userDao=new UserDao();
        User user=userDao.getByName(username);
        PrintWriter out=resp.getWriter();
        if (user!=null){
            //用户名密码正确
            if(password.equals(user.getPassword())){
                req.getSession(true).setAttribute("user",user);//把user存放在session中
                System.out.println("servlet:"+req.getSession().getAttribute("user"));
                if (user.getRoleId()==1){
                    //超级管理员界面
                   url="/vet_management.jsp";
                }else if (user.getRoleId()==2){
                    out.write("普通用户");
                }else{
                    out.write("医生");
                }

            }else{//密码不正确
                url="/login.jsp";
                message="密码错误";
            }
        }else{//用户名不存在
            url="/login.jsp";
            message="用户名不存在";
        }
        System.out.println(message);
        req.setAttribute("message",message);
        req.getRequestDispatcher(url).forward(req,resp);
    }
}
