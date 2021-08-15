package com.wr.servlet;

import com.wr.dao.PetDao;
import com.wr.dao.SpecialityDao;
import com.wr.dao.UserDao;
import com.wr.dao.VetDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toDeletUser")
public class ToDeletUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String userId=request.getParameter("id");
        UserDao userDao=new UserDao();
        PetDao petDao=new PetDao();
        boolean result1=userDao.deleteUserById(userId);
        boolean result2=petDao.deletePetByUserId(userId);
        request.getRequestDispatcher("/user_management.jsp").forward(request,response);
    }
}
