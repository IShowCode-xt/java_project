package com.wr.servlet;

import com.wr.bean.Speciality;
import com.wr.bean.Vet;
import com.wr.dao.SpecialityDao;
import com.wr.dao.VetDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *修改医生信息
 */
@WebServlet("/toUpdateVet")
public class ToUpdateVetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取需要修改的医生ID
        String vetId=request.getParameter("id");
        //查找该用户信息
        VetDao vetDao=new VetDao();
        Vet vet=vetDao.getVetById(vetId);
        request.setAttribute("vet",vet);
        SpecialityDao spDao=new SpecialityDao();
        List<Speciality> spList=spDao.getAllSpecialitys();
        request.setAttribute("spList",spList);
        request.getRequestDispatcher("/update_vet.jsp").forward(request,response);
    }
}
