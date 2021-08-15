<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="main_menu_stu.jsp"%>
<!--/sidebar-->
<div class="main-wrap" >
<%--    <div class="crumb-wrap">--%>
<%--        <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">学生管理</span></div>--%>
<%--    </div>--%>
    <div class="search-wrap">
        <div class="search-content">
            <form action="#" >

                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th><i class="require-red">*</i>用户名：</th>
                            <td>
                                <input id="stu_id" name="stu_id" value="<%=student.getId() %>" hidden="hidden">
                                <input class="common-text required" id="stu_name" name="stu_name" value="<%=student.getUsername() %>" size="50"  type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>学号:</th>
                            <td><input class="common-text" id="stu_idC" name="stu_idC" value="<%=student.getIdcard() %>" size="50"  type="text"></td>
                        </tr>
                        <tr>
                            <th width="120"><i class="require-red">*</i>生日:</th>
                            <td>
                                <input class="common-text required" id="stu_bir" name="stu_bir" value="<%=student.getBirthdate() %>"size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th width="120"><i class="require-red">*</i>班级:</th>
                            <td>
                                <input class="common-text required" id="stu_class" name="stu_class" value="<%=student.getClassId() %>"size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="修改" type="button" onclick="updateInfo()">
                                <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                            </td>
                        </tr>
                        </tbody></table>
            </form>
        </div>
    </div>

</div>
</div>
</body>
<script>
    function updateInfo() {
        if(confirm("确认修改信息吗？")) {
            $.ajax({
                url: "updateStuInfo.do",
                type: "POST",
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                data: {
                    "stu_id":$("#stu_id").val(),
                    "stu_name":$("#stu_name").val(),
                    "stu_idC": $("#stu_idC").val(),
                    "stu_bir": $("#stu_bir").val(),
                    "stu_class": $("#stu_class").val()
                },
                success: function () {
                    alert("修改成功!");
                    // window.location = "/studentInfo.jsp";
                },
                error: function () {
                    alert("修改失败");
                    // window.location = "/studentInfo.jsp";
                }
            })
        }
    }
</script>
</html>
