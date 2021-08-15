package com.wr.servlet;

import com.alibaba.fastjson.JSON;
import com.wr.bean.Visit;
import com.wr.dao.VisitDao;
import com.wr.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/visitServlet")
public class VisitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        VisitDao visitDao=new VisitDao();//病例
        //分页处理
        int cpage = 1;//当前页
        int count = 10;//每页显示的条数
        //获取用户想要跳转的页面
        String page = request.getParameter("cp");//获取用户想要获取的页面
        if (page != null) {
            cpage = Integer.parseInt(page);
        }
        //通过查询获取医生
        String queryType = request.getParameter("queryType");
        String search = request.getParameter("search");
        if(search == null){
            search = "";
        }
        PageInfo<Visit> pageInfo = new PageInfo<Visit>();
        pageInfo = visitDao.selectByPage(queryType,search,cpage,count);


        String dataStr = JSON.toJSONString(pageInfo);
        PrintWriter out =response.getWriter();
        out.write(dataStr);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
