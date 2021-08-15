<%@ page import="com.wr.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>宠物诊所管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
<%--    <link rel="stylesheet" type="text/css" href="css/admin_login.css">--%>
    <script src="js/jquery-1.12.4.min.js" type="text/javascript"></script>
    <script src="js/layer/layer.js"></script>
    <script src="js/vet_management.js" type="text/javascript"></script>


</head>
<body>
    <%
    User user = (User) request.getSession().getAttribute("user");
%>
<div class="topbar-wrap white" >
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="">首页</a></li>
                <li><a href="#" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#"><%=user.getName() %></a></li>
                <li><a href="update_password.jsp">修改密码</a></li>
                <li><a href="quitServlet">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix" id="mainDiv">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>医生管理</a>
                    <ul class="sub-menu">
                        <li><a href="vet_management.jsp"><i class="icon-font">&#xe037;</i>查询医生</a></li>
                        <li><a href="speciality"><i class="icon-font">&#xe017;</i>新增医生</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>用户管理</a>
                    <ul class="sub-menu">
                        <li><a href="user_management.jsp"><i class="icon-font">&#xe005;</i>用户查询</a></li>
                        <li><a href="add_user.jsp"><i class="icon-font">&#xe008;</i>新增用户</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>宠物管理</a>
                    <ul class="sub-menu">
                        <li><a href="visit_management.jsp"><i class="icon-font">&#xe005;</i>宠物病例查询</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
