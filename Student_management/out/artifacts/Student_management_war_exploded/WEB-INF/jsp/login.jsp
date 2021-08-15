<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
  <title>学生管理系统</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin_login.css"/>
  <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/login_config.js" type="text/javascript"></script>
    <script>
        function check() {
            var queryTypeSelect=$("#queryTypeSelect").val();
            document.getElementById("type").value=queryTypeSelect;
         var username=$("#username").val();
            var password=$("#password").val();
            if (username==""||password==""){
                $("#msg").text("账号或密码不能为空!");
                return false;
            }else if (queryTypeSelect==""){
                $("#msg").text("请选择登录类型!");
                return false;
            }
            return  true;
        }
    </script>
    <style>
        body{
            background: url("${pageContext.request.contextPath}/photo/bg.jpeg") no-repeat;


        }
        #queryTypeSelect{
            color: aqua;
            font-family: "Baskerville Old Face";
            size: B4;
        }
        #h11{
            text-align: center;
            color: aqua;
            font-family: "Baskerville Old Face";
            size: B4;
        }
        #la{
            color: #ff9900;
            font-family: "Baskerville Old Face";
        }
        #la1{
            color: #ff9900;
            font-family: "Baskerville Old Face";
        }
        .admin_copyright1{
            font-size: large;
            color: red;
            font-family: "Arial Unicode MS";
        }

    </style>
</head>
<body >
<div class="admin_login_wrap">
  <h1 id="h11">学生管理系统</h1>
  <div class="adming_login_border">
    <div class="admin_input">
      <form  method="post" action="${pageContext.request.contextPath}/login.do" onsubmit="return check()">
        <ul class="admin_items">
            <li>
              请选择登录类型: <select name="search-sort" id="queryTypeSelect">
                    <%--                                    <option value="1">全部</option>--%>
                    <option value="0">我是管理员</option>
                    <option value="1">我是老师</option>
                        <option value="2">我是学生</option>

                </select>
                <input hidden="hidden" id="type" type="text" name="type">
            </li>
          <li>
            <label for="username" id="la">用户名：</label>
            <input type="text" name="username"  id="username" size="40" class="admin_input_style" />
          </li>
          <li>
            <label for="password" id="la1">密码：</label>
            <input type="password" name="password"  id="password" size="40" class="admin_input_style" />
          </li>
<%--          <li>--%>
<%--            <input type="text" name="checkCode"  id="checkCode" placeholder="请输入验证码" size="20" class="admin_input_style"  />--%>
            <%--                        <input type="image" name="img-code" id="img-code"--%>
            <%--                               alt="看不清，点击换图" src="checkCode"--%>
            <%--                               onclick="change(this)">--%>
            <%--                        <img src="checkCode" alt="看不清，点击换图" onclick="change(this)" />--%>
<%--            <canvas id="canvas" width="100" height="30"></canvas>--%>
          </li>
          <li>
            <input type="submit" id="btn" tabindex="3" value="登录" class="btn btn-primary"  />
          </li>
            <li>
                <p class="admin_copyright1"><span id="msg"><%=request.getAttribute("message")==null?"":request.getAttribute("message") %></span></p>
            </li>
        </ul>
      </form>
    </div>
  </div>

</div>
</body>
</html>
