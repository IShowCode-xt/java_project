<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="main_menu.jsp" %>
<script src="js/update_visit.js"></script>
<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="vet?cp=1">医生管理</a><span class="crumb-step">&gt;</span><span>新增医生</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="AddVisitServlet" method="post" id="myform" name="myform">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th width="120"><i class="require-red">*</i>用户名称:</th>
                        <td>
                            <input name="user_id" value="${user.id}" id="user_id" hidden="hidden">
                            <input class="common-text required"  id="user_name" name="user_name" readonly="readonly" value="${user.name}" size="50"  type="text">
                        </td>
                    </tr>
                    <tr>
                        <th width="120"><i class="require-red">*</i>宠物昵称:</th>
                        <td> <input name="pet_id" value="${pet.id}" id="pet_id" hidden="hidden">
                            <input class="common-text required"  id="pet_name" name="pet_name" readonly="readonly"  value="${pet.name}" size="50"  type="text"></td>
                    </tr>
                    <tr>
                        <th width="120"><i class="require-red">*</i>医师:</th>
                        <td>
                          <select name="vet_id">
                              <c:forEach items="${vetList}" var="vet">
                                  <option value="${vet.id}">${vet.name}</option>
                              </c:forEach>
                          </select>
                        </td>
                    </tr>

                    <tr>
                        <th width="120"><i class="require-red">*</i>就诊日期:</th>

                        <td><input class="common-text" id="visitDate" name="visitDate"  size="50"  type="date"></td>

                    </tr>
                    <tr>
                        <th width="120"><i class="require-red">*</i>病情描述:</th>
                        <td><input class="common-text" id="description" name="description"  size="50"  type="text"></td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>治疗方案</th>
                        <td><input class="common-text " id="treatment" name="treatment"  size="50"  type="text"></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="提交" type="submit" >
                            <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                        </td>
                    </tr>
                    </tbody></table>
            </form>
        </div>
    </div>

</div>
<!--/main-->
</div>
</body>
</html>
