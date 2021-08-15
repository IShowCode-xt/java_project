package com.wr.servlet;

import com.wr.dao.PetDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletePetServlet")
public class ToDeletePetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String userId=request.getParameter("user_id");//用户ID
        String petId=request.getParameter("pet_id");//宠物ID
        PetDao petDao=new PetDao();
        boolean result = petDao.deletePetById(Integer.parseInt(petId));
        if (result){
            //删除成功重新请求当前页面
            request.getRequestDispatcher("/toUpdateUser?id="+userId).forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
