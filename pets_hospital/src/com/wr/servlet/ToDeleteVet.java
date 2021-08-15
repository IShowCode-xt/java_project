package com.wr.servlet;

import com.wr.dao.SpecialityDao;
import com.wr.dao.VetDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除医生的servlet
 */
@WebServlet("/toDeleteVet")
public class ToDeleteVet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String vetId=request.getParameter("id");
        VetDao vetDao=new VetDao();
        SpecialityDao spDao=new SpecialityDao();
        boolean result1=vetDao.deleteVetById(vetId);
        boolean result2=spDao.deleteVetSpeciality(vetId);
        request.getRequestDispatcher("/vet_management.jsp").forward(request,response);
    }
}
