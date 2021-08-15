function submitUserInfo(){
    $.ajax({
        url:"updateUserServlet",
        type:"POST",
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        data: {
            "user_id":$("#user_id").val(),
            "user_name": $("#user_name").val(),
            "user_tel": $("#user_tel").val(),
            "user_address": $("#user_address").val()
        },
        success:function(){
            alert("修改成功");
            window.location="user_management.jsp";
        },
        error:function () {
            alert("修改失败");
            window.location="toUpdateUser?id="+$("#user_id").val();
        }
    })
}
function savePet(index) {
    $.ajaxFileUpload({
        type: "post",
        url: "updatePetServlet",
        secureuri:false,
        data: {
                "ownerId": $("#user_id").val(),
                "name":$("#pet_name"+index).val(),
                "birthdate":$("#pet_birthdate"+index).val()
        },
        dataType:"text",
        fileElementId:"pet_img"+index,
        cache:false,
        async:false,
        success:function (data,textStatus,jqXHR) {
            alert("保存成功");
            window.location="toUpdateUser?id="+$("#user_id").val();
        },
        error:function () {
            alert("保存失败");
            window.location="toUpdateUser?id="+$("#user_id").val();
        }
    })
}

function editPet(index) {
    $.ajaxFileUpload({
        url:"updatePetServlet",
        type:"POST",
        secureuri:false,
        data: {
            "id":$("#pet_id"+index).val(),
            "ownerId": $("#user_id").val(),
            "name":$("#pet_name"+index).val(),
            "birthdate":$("#pet_birthdate"+index).val()
        },
        dataType:"text",
        fileElementId:"pet_img"+index,
        cache:false,
        async:false,
        success:function(data,textStatus,jqXHR){
            alert("修改成功");
            window.location="toUpdateUser?id="+$("#user_id").val();
        },
        error:function () {
            alert("修改失败")
            window.location="toUpdateUser?id="+$("#user_id").val();
        }
    })
}

function delPet(index) {
    if(confirm("确认删除该宠物吗？")){
        $.ajax({
            url:"deletePetServlet",
            type:"POST",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            data: {
                "pet_id":$("#pet_id"+index).val(),
                "user_id":$("#user_id").val()
            },
            success:function(){
                alert("删除成功");
                window.location="toUpdateUser?id="+$("#user_id").val();
            },
            error:function () {
                alert("删除失败")
                window.location="toUpdateUser?id="+$("#user_id").val();
            }
        })
    }
}