package com.wr.servlet;

import com.alibaba.fastjson.JSON;
import com.wr.bean.Vet;
import com.wr.dao.VetDao;
import com.wr.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/vet")
public class VetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("application/json;charset=utf-8");
        VetDao vetDao = new VetDao();
        //分页处理
        int cpage = 1;//当前页
        int count = 10;//每页显示的条数
        //获取用户想要跳转的页面
        String page = req.getParameter("cp");//获取用户想要获取的页面
        if (page != null) {
            cpage = Integer.parseInt(page);
        }
        //通过查询获取医生
        String queryType = req.getParameter("queryType");
        String search = req.getParameter("search");
        if(search == null){
            search = "";
        }
        PageInfo<Vet> pageInfo = new PageInfo<Vet>();
        pageInfo = vetDao.selectByPage(queryType,search,cpage,count);


        String dataStr = JSON.toJSONString(pageInfo);
        PrintWriter out =resp.getWriter();
        out.write(dataStr);
        out.flush();
        out.close();
    }

}
