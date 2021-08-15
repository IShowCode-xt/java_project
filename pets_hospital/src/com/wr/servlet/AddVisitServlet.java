package com.wr.servlet;

import com.wr.dao.UserDao;
import com.wr.dao.VisitDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddVisitServlet")
public class AddVisitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        //获取添加用户的基本信息
        String user_id=request.getParameter("user_id");
        String pet_id=request.getParameter("pet_id");
        String vet_id=request.getParameter("vet_id");
        String visitDate=request.getParameter("visitDate");
        String description=request.getParameter("description");
        String treatment=request.getParameter("treatment");
        VisitDao visitDao=new VisitDao();
        boolean result=visitDao.insertVisit(pet_id,vet_id,visitDate,description,treatment);
request.getRequestDispatcher("/visit_management.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
