<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="main_menu_tea.jsp"%>
<!--/sidebar-->
<div class="main-wrap" >
<%--    <div class="crumb-wrap">--%>
<%--        <div class="crumb-list"><i class="icon-font"></i><a href="#">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">学生管理</span></div>--%>
<%--    </div>--%>
    <div class="search-wrap">
        <div class="search-content">
            <form action="#" method="post" id="selectForm" >
                <table class="search-tab">
                    <tr>
                        <th width="120">选择分类:</th>
                        <td>
                            <select name="search-sort" id="queryTypeSelect">
                                <option value="1">全部</option>
                                <option value="2">姓名查询</option>
                                <option value="3">学号查询</option>
                            </select>
                        </td>
                        <th width="70">关键字:</th>
                        <td><input class="common-text" placeholder="关键字" name="keywords"  type="text" id="userSearchTxt"></td>
                        <td><input class="btn btn-primary btn2" name="sub" id="userQueryBut" value="查询" type="button" onclick="st()"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="result-wrap">
        <form name="myform" id="myform" method="post">
            <div class="result-content">
                <table class="result-tab" width="100%" id ="vetListTable">
                    <tr>
                        <th class="tc">学号</th>
                        <th class="tc">姓名</th>
                        <th class="tc">java web</th>
                        <th class="tc">java ee</th>
                        <th class="tc">vue</th>
                        <th class="tc">russion</th>
                        <th class="tc">操作</th>
                    </tr>
                    <tbody id="data_tbody">
                    <c:forEach var="score" items="${list}">
                        <tr>
                            <td>${score.stuCard}</td>
                            <td>${score.username}</td>
                            <td>${score.javaw}</td>
                            <td>${score.javaee}</td>
                            <td>${score.vue}</td>
                            <td>${score.russion}</td>
                            <td>
                                <a class="link-update" href='teafindScoreByStuCard.do?stuCard=${score.stuCard}'>修改</a>
                                <a class="link-del" href='teadelectScore.do?stuCard=${score.stuCard}'>删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="list-page">
                    共有<span id="total_num">${sessionScope.page.total}</span>条记录，当前第<span id="cpage">${sessionScope.page.pageNum}</span>页
                    <a href="javascript:void(0)" id = "first_page" onclick="goPage1()" >首页</a>
                    <a href="javascript:void(0)" id = "prev_page" onclick="goPage2()">上一页</a>
                    <a href="javascript:void(0)" id = "next_page" onclick="goPage3()">下一页</a>
                    <a href="javascript:void(0)" id = "last_page" onclick="goPage4()">尾页</a>
                    <input type="hidden" name="pageNum" id="pageNum" value="${sessionScope.page.pageNum}">
                </div>
            </div>
        </form>
    </div>
</div>
</div>
</body>
<script >
    var pageNum=${sessionScope.page.pageNum};//当前页
    var pages=${sessionScope.page.pages};//总页数
    var hasPreviousPage=${sessionScope.page.hasPreviousPage};//是否有上一页
    var hasNextPage=${sessionScope.page.hasNextPage};//是否有下一页
    function st() {
        var userSearchTxt=$("#userSearchTxt").val();
        var type=$("#queryTypeSelect").val();
        location.href="findScore.do?type="+type+"&userSearchTxt="+userSearchTxt;
    }
    function goPage1() {
        var userSearchTxt=$("#userSearchTxt").val();
        var type=$("#queryTypeSelect").val();
        var pagenumber=1;
        location.href="findScorePage.do?type="+type+"&pageNumber="+pagenumber+"&userSearchTxt="+userSearchTxt;
    }
    function goPage2() {
        var userSearchTxt=$("#userSearchTxt").val();
        var type=$("#queryTypeSelect").val();
        if (pageNum<=1){var pagenum=1;}
        var pagenum=pageNum-1;

        location.href="findScorePage.do?type="+type+"&pageNumber="+pagenum+"&userSearchTxt="+userSearchTxt;
    }
    function goPage3() {
        var userSearchTxt=$("#userSearchTxt").val();
        var type=$("#queryTypeSelect").val();
        if (pageNum>=pages){var pagenum=pages;}
        var pagenum=pageNum+1;
        location.href="findScorePage.do?type="+type+"&userSearchTxt="+userSearchTxt+"&pageNumber="+pagenum;
    }
    function goPage4() {
        var userSearchTxt=$("#userSearchTxt").val();
        var type=$("#queryTypeSelect").val();
        var pagenum=pages;
        location.href="findScorePage.do?type="+type+"&pageNumber="+pagenum+"&userSearchTxt="+userSearchTxt;
    }
</script>
</html>
