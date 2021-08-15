package com.wr.servlet;

import com.wr.dao.UserDao;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        //获取添加用户的基本信息
        String user_name=request.getParameter("user_name");
        String user_tel=request.getParameter("user_tel");
        String user_address=request.getParameter("user_address");
        String user_Id=request.getParameter("user_id");
        UserDao userDao=new UserDao();
        if (StringUtils.isEmpty(user_Id)){
            boolean result=userDao.toAddUser(user_name,user_tel,user_address);
        }else{
            boolean result=userDao.toUpdateUser(user_Id,user_name,user_tel,user_address);
        }

        request.getRequestDispatcher("/user_management.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
