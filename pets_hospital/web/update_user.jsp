<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="main_menu.jsp" %>
<script src="js/ajaxfileupload.js" type="text/javascript"></script>
<script src="js/update_user.js" type="text/javascript"></script>
<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="vet?cp=1">医生管理</a><span class="crumb-step">&gt;</span><span>新增医生</span></div>
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
                            <input class="common-text required" id="user_name" name="user_name" value="${user.name}" size="50"  type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>电话：</th>
                        <td><input class="common-text" id="user_tel" name="user_tel" value="${user.tel}" size="50"  type="text"></td>
                    </tr>
                    <tr>
                        <th width="120"><i class="require-red">*</i>家庭住址：</th>
                        <td>
                            <input class="common-text required" id="user_address" name="user_address" value="${user.address}"size="50" value="" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="提交并返回" type="button" onclick="submitUserInfo()">
                            <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                            <button type="button" class="btn btn-primary btn6 mr10" onclick="addPet(${user.id})">宠物添加</button>
                        </td>
                    </tr>
                    </tbody></table>

                <!-- 宠物数据 -->
                <table class="insert-tab" width="60%">
                    <tbody id="petTbody">
                    <c:forEach items="${pets}" var="pet" varStatus="petStatus">
                        <tr>
                            <td style="position:relative;width:100px;height:100px;">
                                <input id="pet_img${petStatus.index}" name="pet_img"  type="file" style="position: absolute;left:0px;top:0px; z-index: 10; opacity: 0;width: 100px; height: 100px;" onchange="imgChange(${petStatus.index})">
                                <img src="${pet.photo}"  id="pet_pic${petStatus.index}" style="position: absolute; z-index: 9;left:0px;top:0px; width: 100px; height: 100px">
                            </td>
                            <td>
                                <i class="require-red">*</i>宠物名称：
                                <input type="hidden" id="pet_id${petStatus.index}" value="${pet.id}">
                                <input class="common-text required" id="pet_name${petStatus.index}" name="pet_name" size="30" value="${pet.name}" type="text">
                                <br>
                                <i class="require-red">*</i>出生日期：
                                <input class="common-text required" id="pet_birthdate${petStatus.index}" name="pet_name" size="30" value="${pet.birthdate}" type="date">
                            </td>
                            <td>
                                <button type="button" class="btn btn-primary btn6 mr10" onclick="editPet(${petStatus.index})">修改</button>
                                <button type="button" class="btn btn-primary btn6 mr10" onclick="delPet(${petStatus.index},${user.id})">删除</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </div>

</div>
<!--/main-->
</div>
</body>
</html>
<script type="text/javascript">
    function addPet(userId) {
         var trSize = $("#petTbody").find("tr").length;
        var html ="<tr>" +
            '<td style="position:relative;width:100px;height:100px;">'+
            '<input style="position: absolute;left:0px;top:0px; z-index: 10; opacity: 0;width: 100px; height: 100px;" id="pet_img'+trSize+'" name="pet_img"  type="file" onchange="imgChange('+trSize+')"/>'+
            '<img id="pet_pic'+trSize+'" src="photo/muban.jpg" title="点击更换图片" style="position: absolute; z-index: 9;left:0px;top:0px; width: 100px; height: 100px">'+
            '</td>' +
            '<td><i class="require-red">*</i>宠物名称：'+
            '<input class="common-text required" id="pet_name'+trSize+'" name="pet_name" size="30" value="" type="text">' +
            '<br><i class="require-red">*</i>宠物出生日期：'+
            '<input class="common-text required" id="pet_birthdate'+trSize+'" name="pet_name" size="30" value="" type="date"></td>' +
            '<td><button type="button" class="btn btn-primary btn6 mr10" onclick="savePet('+trSize+')">保存</button></td>' +
            "</tr>"
        $("#petTbody").append(html);
        // $(function () {
        //     $("#pet_img"+trSize+"").change(function () {
        //         var obj= $("#pet_img"+trSize+"")[0].files[0];
        //         console.log(obj);
        //         var wuc=window.URL.createObjectURL(obj);
        //         $("#pet_pic"+trSize).attr('src',wuc);
        //         console.log(wuc);
        //     });
        // });
    }
    function imgChange(index) {
        var obj= $("#pet_img"+index+"")[0].files[0];
        var wuc=window.URL.createObjectURL(obj);
        $("#pet_pic"+index).attr('src',wuc);
        console.log(wuc);
    }
</script>