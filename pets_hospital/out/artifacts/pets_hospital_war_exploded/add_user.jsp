<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="main_menu.jsp" %>
<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="user_management.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="addUserServlet" method="post"  >
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>姓名：</th>
                        <td>
                            <input class="common-text required" id="user_name" name="user_name" size="50"  type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>电话：</th>
                        <td><input class="common-text" id="user_tel" name="user_tel" size="50"  type="text"></td>
                    </tr>
                    <tr>
                        <th width="120"><i class="require-red">*</i>家庭住址：</th>
                        <td>
                            <input class="common-text required" id="user_address" name="user_address" size="50" value="" type="text">
                        </td>
                    </tr>

                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                            <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                        </td>
                    </tr>
                    </tbody></table>
            </form>
        </div>
    </div>

</div>
<!--/main-->
</div>
</body>
</html>

