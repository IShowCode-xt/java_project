<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="main_menu.jsp" %>
<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="vet?cp=1">医生管理</a><span class="crumb-step">&gt;</span><span>新增医生</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form  method="post" id="myform" name="myform">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>姓名：</th>
                        <td>
                            <input id="user_id" name="user_id" value="${user.id}" hidden="hidden">
                            <input class="common-text required" id="user_name" name="user_name" value="${user.name}" size="50"  type="text" readonly="readonly">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>电话：</th>
                        <td><input class="common-text" id="user_tel" name="user_tel" value="${user.tel}" size="50"  type="text" readonly="readonly"></td>
                    </tr>
                    <tr>
                        <th width="120"><i class="require-red">*</i>家庭住址：</th>
                        <td>
                            <input class="common-text required" id="user_address" name="user_address" value="${user.address}"size="50" value="" type="text" readonly="readonly">
                        </td>
                    </tr>
                    <tr>

                        <th></th>
                        <td>
                        </td>
                    </tr>
                    </tbody></table>
<br><br>
                <!-- 宠物数据 -->
                <table class="insert-tab" width="60%">
                    <tbody id="petTbody">
                    <c:forEach items="${pets}" var="pet" varStatus="petStatus">
                        <tr>
                            <td width="100px" height="100px">
                                <img src="${pet.photo}" width="100px" height="100px">
                            </td>
                            <td>
                                <i class="require-red">*</i>宠物名称：
                                <input type="hidden" id="pet_id${petStatus.index}" value="${pet.id}">
                                <input class="common-text required" id="pet_name${petStatus.index}" name="pet_name" size="30" value="${pet.name}" type="text" readonly="readonly">
                                <br>
                                <i class="require-red">*</i>出生日期：
                                <input class="common-text required" id="pet_birthdate${petStatus.index}" name="pet_name" size="30" value="${pet.birthdate}" type="text" readonly="readonly">
                            </td>
                            <td>
                                <button type="button" class="btn btn-primary btn-6 mr10" onclick="addVisit(${petStatus.index})">添加病例</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <br>
                <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
            </form>
        </div>
    </div>

</div>
<!--/main-->

<script>

    function addVisit(index) {
        window.location.href="toaddVisitServlet?user_id="+ $("#user_id").val()+"&pet_id=" + $("#pet_id"+index).val();

    }
</script>
</body>
</html>
