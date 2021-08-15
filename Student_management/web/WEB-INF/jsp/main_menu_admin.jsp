<%@ page import="com.student.po.Admin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>学生管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
    <%--    <link rel="stylesheet" type="text/css" href="css/admin_login.css">--%>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/layer/layer.js"></script>


</head>
<body>
    <%
    Admin admin = (Admin) request.getSession().getAttribute("USER_SESSION");
    String pa=admin.getPassword();
    int id=admin.getId();
    int roleid=admin.getRoleId();
    if(roleid!=0){
        request.setAttribute("msg","权限不够请重新登陆!");
        request.getRequestDispatcher("${pageContext.request.contextPath}/jsp/login.jsp").forward(request,response);
    }

%>
<div class="topbar-wrap white" >
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">超级管理员管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="#">首页</a></li>
                <li><a href="#" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#"><%=admin.getUsername() %></a></li>
                <li><a href="update_password_ad.do">修改密码</a></li>
                <li><a href="logout.do">退出</a></li>
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
                    <a href="#"><i class="icon-font">&#xe018;</i>学生信息管理</a>
                    <ul class="sub-menu">
                        <li><a href="afindStu.do?type=1&userSearchTxt=null"><i class="icon-font">&#xe037;</i>查询学生信息</a></li>
                    </ul>
                    <ul class="sub-menu">
                        <li><a href="admin_addstuI.do"><i class="icon-font">&#xe037;</i>添加学生信息</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>老师信息管理</a>
                    <ul class="sub-menu">
                        <li><a href="afindTea.do?type=1&userSearchTxt=null"><i class="icon-font">&#xe037;</i>查询老师信息</a></li>
                    </ul>
                    <ul class="sub-menu">
                        <li><a href="admin_addteaI.do"><i class="icon-font">&#xe037;</i>添加老师信息</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>学生成绩管理</a>
                    <ul class="sub-menu">
                        <li><a href="afindScore.do?type=1&userSearchTxt=null"><i class="icon-font">&#xe005;</i>查询学生成绩</a></li>
                    </ul>
                    <ul class="sub-menu">
                        <li><a href="admin_addstuS.do"><i class="icon-font">&#xe005;</i>添加学生成绩</a></li>
                    </ul>
                </li>

            </ul>
        </div>
    </div>
