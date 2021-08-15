<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="main_menu_admin.jsp" %>

<%--        <div class="crumb-wrap">--%>
<%--            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">修改密码</span></div>--%>
<%--        </div>--%>
<div class="admin_login_wrap" >
        <div class="adming_login_border">
            <div class="admin_input">
                <form  method="post" id="updataForm" action="#">
                    <ul class="admin_items">
                        <li>
                            <label for="oldPassword"><span style="color: red">*</span>旧密码：</label>
                            <input type="password" name="oldPassword"  id="oldPassword" size="30" class="admin_input_style" />
                        </li>
                        <li>
                            <label for="newPassword1"><span style="color: red">*</span>新密码：</label>
                            <input type="password" name="newPassword1"  id="newPassword1" size="30" class="admin_input_style" />
                        </li>
                        <li>
                            <label for="newPassword2"><span style="color: red">*</span>确认新密码：</label>
                            <input type="password" name="newPassword2"  id="newPassword2" size="30" class="admin_input_style" />
                        </li>
                        <li>
                            <input type="button" id="btn" tabindex="3" value="修改密码" class="btn btn-primary" onclick="checkUpdate()"/>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    <p class="admin_copyright"><span id="msg"><%=request.getAttribute("message")==null?"":request.getAttribute("message") %></span></p>
    </div>
</div>
</body>
<script>
    function checkUpdate() {
        var oldPwd=$("#oldPassword").val();
        var newPwd1=$("#newPassword1").val();
        var newPwd2=$("#newPassword2").val();
        if (oldPwd=="" ||newPwd1==""||newPwd2==""){
            alert("所有密码均不能为空");
            return;
        }
        var Pwd="<%= pa%>";
        var id="<%= id%>";

        if (Pwd!==oldPwd){
            alert("旧密码输入错误")
            return;
        }
        if (newPwd1!==newPwd2){
            alert("新密码输入不一致!")
            return;
        }
        if(confirm("确认修改密码吗？")) {
            $.ajax({
                url: "updateAdminpassword.do",
                type: "POST",
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                data: {
                   "id":id,
                    "newPassword2":newPwd2
                },
                success: function () {
                    alert("修改成功,返回登录页面!");
                    window.location = "logins.do";
                },
                error: function () {
                    alert("修改失败");
                    window.location = "update_password_ad.do";
                }
            })
        }
    }
</script>
</html>
