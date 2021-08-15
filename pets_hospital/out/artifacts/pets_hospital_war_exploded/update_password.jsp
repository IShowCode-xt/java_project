<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="main_menu.jsp" %>

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">修改密码</span></div>
        </div>
<div class="admin_login_wrap" >
        <div class="adming_login_border">
            <div class="admin_input">
                <form  method="post" id="updataForm" action="updatePasswordServlet">
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

        if(confirm("确认修改密码吗？")) {
            $.ajax({
                url: "updatePasswordServlet",
                type: "POST",
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                data: {
                    "oldPassword": $("#oldPassword").val(),
                    "newPassword1": $("#newPassword1").val(),
                    "newPassword2": $("#newPassword2").val()
                },
                success: function () {
                    alert("修改成功");
                    window.location = "/ph/login.jsp";
                },
                error: function () {
                    alert("修改失败");
                    window.location = "/ph/update_password.jsp";
                }
            })
        }
    }
</script>
</html>
