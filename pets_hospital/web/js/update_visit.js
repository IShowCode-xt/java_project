function submitUserInfo(){
    console.log($("#pet_id").val());
    $.ajax({
        url:"UpdateVisitServlet",
        type:"POST",
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        data: {
            "pet_id":$("#pet_id").val(),
            "pet_vname": $("#pet_vname").val(),
            "pet_visitdate": $("#pet_visitdate").val(),
            "pet_description": $("#pet_description").val(),
            "pet_treatment": $("#pet_treatment").val(),
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
