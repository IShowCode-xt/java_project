<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="main_menu.jsp" %>
<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="vet_management.jsp">医生管理</a><span class="crumb-step">&gt;</span><span>新增医生</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="addVet" method="post" id="myform" name="myform">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>姓名：</th>
                        <td>
                            <input class="common-text required" id="vet_name" name="vet_name" size="50"  type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>电话：</th>
                        <td><input class="common-text" id="vet_tel" name="vet_tel" size="50"  type="text"></td>
                    </tr>
                    <tr>
                        <th width="120"><i class="require-red">*</i>擅长专业：</th>
                        <td>
                            <c:forEach var="speciality" items="${spList}">
                                <input name="speciality" type="checkbox" value="${speciality.id}" />${speciality.name}&nbsp;&nbsp;&nbsp;&nbsp;
                            </c:forEach>
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
