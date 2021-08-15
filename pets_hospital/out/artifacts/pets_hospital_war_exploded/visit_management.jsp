<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="main_menu.jsp"%>
    <!--/sidebar-->
    <div class="main-wrap" >
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">宠物管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post" >
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="queryTypeSelect">
                                    <option value="1">全部</option>
                                    <option value="2">宠物姓名</option>
                                    <option value="3">医生姓名</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords"  type="text" id="userSearchTxt"></td>
                            <td><input class="btn btn-primary btn2" name="sub" id="userQueryBut" value="查询" type="button"></td>
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
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                            <th class="tc">ID</th>
                            <th class="tc">昵称</th>
                            <th class="tc">医师</th>
                            <th class="tc">时间</th>
                            <th class="tc">症状</th>
                            <th class="tc">治疗方案</th>
                            <th class="tc">操作</th>
                        </tr>
                        <tbody id="data_tbody">

                        </tbody>
                    </table>
                    <div class="list-page">
                        共有<span id="total_num"></span>条记录，当前<span id="cpage"></span>/<span id="total_page"></span>页
                        <a href="javascript:void(0)" id = "first_page" onclick="goPage(1)" >首页</a>
                        <a href="javascript:void(0)" id = "prev_page" onclick="goPage(2)">上一页</a>
                        <a href="javascript:void(0)" id = "next_page" onclick="goPage(3)">下一页</a>
                        <a href="javascript:void(0)" id = "last_page" onclick="goPage(4)">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script src="js/visit_management.js" type="text/javascript"></script>
</html>
