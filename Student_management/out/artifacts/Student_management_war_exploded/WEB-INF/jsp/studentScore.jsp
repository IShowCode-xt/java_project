<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="main_menu_stu.jsp"%>
<!--/sidebar-->
<div class="main-wrap" >
<%--    <div class="crumb-wrap">--%>
<%--        <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">学生管理</span></div>--%>
<%--    </div>--%>
    <div class="search-wrap">
        <div class="search-content">
            <form name="myform" id="myform" method="post">
                <div class="result-content">
                    <table class="result-tab" width="100%" id ="vetListTable">
                        <tr>
                            <th class="tc">学号</th>
                            <th class="tc">用户名</th>
                            <th class="tc">java web</th>
                            <th class="tc">java ee</th>
                            <th class="tc">vue</th>
                            <th class="tc">俄语</th>
                        </tr>
                        <tbody id="data_tbody">
                        <tr>
                            <td>
                               <%=student.getIdcard()%>
                            </td>
                            <td><%=student.getUsername()%></td>
                            <td>${sco.javaw}</td>
                            <td>${sco.javaee}</td>
                            <td>${sco.vue}</td>
                            <td>${sco.russion}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </form>
        </div>
    </div>

</div>
</div>
</body>
</html>
