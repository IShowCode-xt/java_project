function check() {
    var queryTypeSelect=$("#queryTypeSelect").val();
    var username=$("#username").val();
    var password=$("#password").val();
    if (username==""||password==""){
        $("#msg").text("账号或密码不能为空!");
        return false;
    }else if (queryTypeSelect==""){
        $("#msg").text("请选择登录类型!");
        return false;
    }
    $.ajax({
        url:"${pageContext.request.contextPath}/login.do?",
        type:"post",
        dataType:"json",
        success:function (data) {
            var html = "";
            for(var i = 0 ; i < data.data.length; i++){
                html += "<tr>";
                html += "<td class='tc'><input name='id"+i+"' value='"+data.data[i].id+"' type='checkbox'></td>";
                html += "<td class='tc'>"+data.data[i].id+"</td>"
                html += "<td class='tc'>"+data.data[i].name+"</td>"
                html += "<td class='tc'>"+data.data[i].tel+"</td>"
                html += "<td class='tc'>"+data.data[i].address+"</td>"
                html += "<td class='tc'><a class='link-update' href='toUpdateUser?id="+data.data[i].id+"'>修改</a>&nbsp;&nbsp;"
                html += "<a class=\"link-del\" href=\"javascript:deleteVet('确认删除"+data.data[i].name+"吗?','"+data.data[i].id+"');\">删除</a>&nbsp;&nbsp;"
                html += "<a class='link-update' href='toShowDetailUser?id="+data.data[i].id+"'>查看</a>";
                html += "</td>";
                html += "</tr>"
            }
            $("#data_tbody").html(html);
            $("#total_num").text(data.totalNum);
            $("#cpage").text(data.cpage);
            $("#total_page").text(data.totalPage);

        }
    })
}