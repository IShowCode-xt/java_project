package com.wr.servlet;

import com.wr.dao.PetDao;
import com.wr.dao.VisitDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toDeleteVisit")
public class ToDeleteVisitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String visitId=request.getParameter("id");//用户ID
        VisitDao visitDao=new VisitDao();
        boolean result = visitDao.deleteVisitById(Integer.parseInt(visitId));
        if (result){
            //删除成功重新请求当前页面
            request.getRequestDispatcher("/visit_management.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
