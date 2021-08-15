package com.wr.servlet;

import com.wr.bean.Pet;
import com.wr.bean.User;
import com.wr.bean.Vet;
import com.wr.dao.PetDao;
import com.wr.dao.UserDao;
import com.wr.dao.VetDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/toaddVisitServlet")
public class ToAddVisitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String user_id=request.getParameter("user_id");
        String pet_id=request.getParameter("pet_id");
        UserDao userDao=new UserDao();
        User user=userDao.getVetById(user_id);
        PetDao petDao=new PetDao();
        Pet pet=petDao.getPetById(pet_id);
        request.setAttribute("user",user);
        request.setAttribute("pet",pet);
       VetDao vetDao=new VetDao();
       List<Vet> vetList=vetDao.getListVet();
      request.setAttribute("vetList",vetList);
      request.getRequestDispatcher("/add_visit.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
