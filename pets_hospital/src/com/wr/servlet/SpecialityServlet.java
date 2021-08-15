package com.wr.servlet;

import com.wr.bean.Speciality;
import com.wr.dao.SpecialityDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *医生专业servlet
 */
@WebServlet("/speciality")
public class SpecialityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有专业名称
        response.setContentType("text/html;charset=utf-8");
        SpecialityDao spDao=new SpecialityDao();
        List<Speciality> spList=spDao.getAllSpecialitys();
        request.setAttribute("spList",spList);
        request.getRequestDispatcher("/add_vet.jsp").forward(request,response);
    }
}
