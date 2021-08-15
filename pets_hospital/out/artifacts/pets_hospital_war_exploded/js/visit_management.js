$(document).ready(function () {
    //1.绑定医生的查询事件
    $("#userQueryBut").on('click',function () {
        getData(1);
    });
    $("#userQueryBut").click();
})

function goPage(type) {
    var cpage = 0;
    var rcpage = parseInt($("#cpage").text());
    var totalPage = parseInt($("#total_page").text());
    if(type == 1){
        cpage = 1;
    }else if(type == 2){
        cpage = rcpage -1 < 1 ? 1 : rcpage -1;
    }else if(type == 3){
        cpage = rcpage +1 > totalPage ? totalPage : rcpage +1;
    }else if(type == 4){
        cpage = totalPage;
    }
    getData(cpage);
}

function getData(cpage) {
    var search = $("#userSearchTxt").val();
    var queryType = $("#queryTypeSelect").val();
    $.ajax({
        url:"visitServlet?search="+search+"&queryType="+queryType+"&cp="+cpage,
        type:"post",
        dataType:"json",
        success:function (data) {
            var html = "";
            for(var i = 0 ; i < data.data.length; i++){
                html += "<tr>";
                html += "<td class='tc'><input name='id"+i+"' value='"+data.data[i].id+"' type='checkbox'></td>";
                html += "<td class='tc'>"+data.data[i].id+"</td>"
                html += "<td class='tc'>"+data.data[i].pname+"</td>"
                html += "<td class='tc'>"+data.data[i].vname+"</td>"
                html += "<td class='tc'>"+data.data[i].visitdate+"</td>"
                html += "<td class='tc'>"+data.data[i].description+"</td>"
                html += "<td class='tc'>"+data.data[i].treatment+"</td>"
                html += "<td class='tc'><a class='link-update' href='UpdateVisitServlet?id="+data.data[i].id+"'>修改</a>&nbsp;&nbsp;"
                html += "<a class=\"link-del\" href=\"javascript:deleteVisit('确认删除"+data.data[i].name+"吗?','"+data.data[i].id+"');\">删除</a>&nbsp;&nbsp;"

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

function deleteVisit(mesg,id) {
    if(confirm(mesg)){
        location.href="toDeleteVisit?id="+id;
    }

}
