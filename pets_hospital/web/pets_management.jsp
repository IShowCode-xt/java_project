<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="main_menu.jsp"%>
    <!--/sidebar-->
    <div class="main-wrap" >
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">医生管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="queryTypeSelect">
                                    <option value="1">全部</option>
                                    <option value="2">姓名查询</option><option value="3">专业查询</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords"  type="text" id="vetSearchTxt"></td>
                            <td><input class="btn btn-primary btn2" name="sub" id="vetQueryBut" value="查询" type="button"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="javascript:void(0)" id="vetAddBut"><i class="icon-font"></i>新增医生</a>
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%" id ="vetListTable">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                            <th>ID</th>
                            <th>姓名</th>
                            <th>电话</th>
                            <th>专业</th>
                            <th>操作</th>
                        </tr>
                        <tbody>
                        <c:forEach var="vets" items="${vetsList}">
                            <tr>
                                <td>
                                    <input name="id[]" value="${vets.id}" type="checkbox">
                                </td>
                                <td>${vets.id}</td>
                                <td>${vets.name}</td>
                                <td>${vets.tel}</td>
                                <td>${vets.specialityStr}</td>
                                <td>
                                   <a class="link-update" href="#">修改</a>
                                   <a class="link-del" href="#">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="list-page">
                        共有000条记录，当前1/4页
                        <a href="">首页</a>
                        <a href="">上一页</a>
                        <a href="">下一页</a>
                        <a href="">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
