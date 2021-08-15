<%@ page import="com.student.po.Student" %>
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
    Student student = (Student) request.getSession().getAttribute("USER_SESSION");
    String idc=student.getIdcard();
    request.getSession().setAttribute("idc",idc);
    String pa=student.getPassword();
    int id=student.getId();
    int roleid=student.getRoleId();
    if(roleid!=2){
        request.setAttribute("msg","权限不够请重新登陆!");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
%>
<div class="topbar-wrap white" >
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">学生管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="#">首页</a></li>
                <li><a href="#" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#"><%=student.getUsername() %></a></li>
                <li><a href="update_password_stu.do">修改密码</a></li>
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
                        <li><a href="studentInfo.do"><i class="icon-font">&#xe037;</i>查询学生信息</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>学生成绩管理</a>
                    <ul class="sub-menu">
                        <li><a href="stufindScoreByStuId.do?stuCard=<%=student.getIdcard()%>"><i class="icon-font">&#xe005;</i>查询学生成绩</a></li>
                    </ul>
                </li>

            </ul>
        </div>
    </div>

