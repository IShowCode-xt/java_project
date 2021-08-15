package com.wr.servlet;

import com.wr.bean.Pet;
import com.wr.bean.User;
import com.wr.bean.Visit;
import com.wr.dao.PetDao;
import com.wr.dao.UserDao;
import com.wr.dao.VisitDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UpdateVisitServlet")
public class UpdateVisitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取需要修改的用户ID
        String visitId=request.getParameter("id");
//        String visitdate=request.getParameter("pet_visitdate");
//        String description=request.getParameter("pet_description");
//        String treatment=request.getParameter("pet_treatment");
        //查找该用户信息
        VisitDao visitDao=new VisitDao();
       Visit visit= visitDao.getVisitById(visitId);
        request.setAttribute("visit",visit);
//        visitDao.toUpdateVisit(visitId,visitdate,description,treatment);
        request.getRequestDispatcher("/update_visit.jsp").forward(request,response);
    }
}
