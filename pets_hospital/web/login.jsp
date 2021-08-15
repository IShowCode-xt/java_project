<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宠物诊所管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/admin_login.css"/>
    <script src="js/jquery-1.12.4.min.js" type="text/javascript"></script>
    <script src="js/login_config.js" type="text/javascript"></script>

</head>
<body>
<div class="admin_login_wrap">
    <h1>用户登录</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form  method="post" id="loginForm">
                <ul class="admin_items">
                    <li>
                        <label for="user">用户名：</label>
                        <input type="text" name="username"  id="user" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="pwd"  id="pwd" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <input type="text" name="checkCode"  id="checkCode" placeholder="请输入验证码" size="20" class="admin_input_style"  />
                        <input type="image" name="img-code" id="img-code"
                               src="checkCode"
                               onclick="change(this)">
<%--                        <img src="checkCode"  onclick="change(this)" />--%>
                        <canvas id="canvas" width="100" height="30"></canvas>
                    </li>
                    <li>
                        <input type="button" id="btn" tabindex="3" value="提交" class="btn btn-primary" onclick="checkLogin()"/>
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <p class="admin_copyright"><span id="msg"><%=request.getAttribute("message")==null?"":request.getAttribute("message") %></span></p>
</div>
</body>
</html>
