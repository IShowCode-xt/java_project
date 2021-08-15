package com.wr.servlet;
/**验证码实现思路：
 *在Servlet中随机产生验证码字符序列，并计入session中，
 *JSP中以图片的形式进行显示。当用户在JSP表单中输入验证码并提交时，
 *在相应的Servlet中验证是否与session中保存的验证码一致。
 */

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/testCode")
public class TestCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try{
            String checkCode=req.getParameter("checkCode");
            //校验验证码
            String code = (String)req.getSession().getAttribute("code");
            if(StringUtils.isEmpty(checkCode)){
                writer.write("验证码为空");
                return;
            }
            if(checkCode.equals(code.toLowerCase())){
                writer.write("ok");
            }else {
                writer.println("error");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            writer.flush();
            writer.close();
        }
    }
}
