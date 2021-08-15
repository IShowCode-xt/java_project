package com.wr.servlet;

import com.wr.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        //获取需要修改的用户ID
        String userId=request.getParameter("user_id");
        String user_name=request.getParameter("user_name");
        String user_tel=request.getParameter("user_tel");
        String user_address=request.getParameter("user_address");
        UserDao userDao=new UserDao();
        boolean result = userDao.toUpdateUser(userId, user_name, user_tel, user_address);
        request.getRequestDispatcher("/user_management.jsp").forward(request,response);

    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
