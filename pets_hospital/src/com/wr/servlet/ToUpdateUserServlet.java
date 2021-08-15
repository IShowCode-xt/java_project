package com.wr.servlet;

import com.wr.bean.Pet;
import com.wr.bean.User;
import com.wr.dao.PetDao;
import com.wr.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *修改用户信息
 */
@WebServlet("/toUpdateUser")
public class ToUpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取需要修改的用户ID
        String userId=request.getParameter("id");
        //查找该用户信息
        UserDao userDao=new UserDao();
        User user=userDao.getVetById(userId);
        request.setAttribute("user",user);
        //查询用户的宠物
        PetDao petDao = new PetDao();
        List<Pet> pets = petDao.getPetListByUserId(Integer.valueOf(userId));
        request.setAttribute("pets",pets);
        request.getRequestDispatcher("/update_user.jsp").forward(request,response);
    }
}
