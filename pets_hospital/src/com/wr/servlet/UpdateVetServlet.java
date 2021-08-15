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
 * 修改医生信息
 */
@WebServlet("/updateVet")
public class UpdateVetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String vetId=request.getParameter("vet_id");
        String vet_name=request.getParameter("vet_name");
        String vet_tel=request.getParameter("vet_tel");
        String[] specialitys=request.getParameterValues("speciality");
        //将医生的基本信息添加在医生表中
        VetDao vetDao=new VetDao();
        boolean result1=vetDao.updateVet(vetId,vet_name,vet_tel);
        //修改医生和专业的对应关系，多对多，所以就会先删再插入
        SpecialityDao spDao=new SpecialityDao();
        boolean delResult=spDao.deleteVetSpeciality(vetId);
        boolean result2=spDao.addVetSpeciality(Integer.parseInt(vetId),specialitys);
        request.getRequestDispatcher("/vet_management.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
