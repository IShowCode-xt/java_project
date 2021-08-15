<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="main_menu_admin.jsp" %>
<div class="main-wrap">
<%--    <div class="crumb-wrap">--%>
<%--        <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="vet?cp=1">医生管理</a><span class="crumb-step">&gt;</span><span>新增医生</span></div>--%>
<%--    </div>--%>
    <div class="result-wrap">
        <div class="result-content">
            <form  method="post" id="myform" name="myform" action="adminupdateScore.do">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>姓名：</th>
                        <td>
                            <input id="id" name="id" value="${sco.stuCard}" hidden="hidden">
                            <input class="common-text required" id="username" name="username" value="${sco.username}" size="50"  type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>学号：</th>
                        <td><input class="common-text" id="stuCard" name="stuCard" readonly="readonly" value="${sco.stuCard}" size="50"  type="text"></td>
                    </tr>
                    <tr>
                        <th width="120"><i class="require-red">*</i>java web：</th>
                        <td>
                            <input class="common-text required" id="javaw" name="javaw" value="${sco.javaw}"size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th width="120"><i class="require-red">*</i>java ee：</th>
                        <td>
                            <input class="common-text required" id="javaee" name="javaee" value="${sco.javaee}"size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th width="120"><i class="require-red">*</i>vue：</th>
                        <td>
                            <input class="common-text required" id="vue" name="vue" value="${sco.vue}"size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th width="120"><i class="require-red">*</i>russion：</th>
                        <td>
                            <input class="common-text required" id="russion" name="russion" value="${sco.russion}"size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="提交并返回" type="submit" >
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
