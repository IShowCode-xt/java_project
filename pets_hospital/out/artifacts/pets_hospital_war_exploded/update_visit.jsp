<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="main_menu.jsp" %>
<script src="js/update_visit.js"></script>
<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="vet?cp=1">医生管理</a><span class="crumb-step">&gt;</span><span>新增医生</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="UpdateVisitServlet" method="post" id="myform" name="myform">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>昵称:</th>
                        <td>
                            <input name="pet_id" value="${visit.id}" id="pet_id" hidden="hidden">
                            <input class="common-text required" readonly="readonly" id="pet_name" name="pet_name" value="${visit.pname}" size="50"  type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>医师:</th>
                        <td><input class="common-text" id="pet_vname" readonly="readonly"  name="pet_vname" value="${visit.vname}" size="50"  type="text"></td>
                    </tr>
                    <tr>
                        <th width="120"><i class="require-red">*</i>时间:</th>

                        <td><input class="common-text" id="pet_visitdate" readonly="readonly" name="pet_visitdate" value="${visit.visitdate}" size="50"  type="text"></td>

                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>症状:</th>
                        <td><input class="common-text" id="pet_description" name="pet_description" value="${visit.description}" size="50"  type="text"></td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>治疗方案</th>
                        <td><input class="common-text" id="pet_treatment" name="pet_treatment" value="${visit.treatment}" size="50"  type="text"></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="修改" type="button" onclick="submitUserInfo()">
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
