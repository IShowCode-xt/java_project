$(document).ready(function () {
    //1.绑定医生的查询事件
    $("#vetQueryBut").on('click',function () {
        getData(1);
    });
    $("#vetQueryBut").click();
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
    var search = $("#vetSearchTxt").val();
    var queryType = $("#queryTypeSelect").val();
    $.ajax({
        url:"/ph/vet?type=select&search="+search+"&queryType="+queryType+"&cp="+cpage,
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
                html += "<td class='tc'>"+data.data[i].specialityStr+"</td>"
                html += "<td class='tc'><a class='link-update' href='toUpdateVet?id="+data.data[i].id+"'>修改</a>&nbsp;&nbsp;"
                html += "<a class=\"link-del\" href=\"javascript:deleteVet('确认删除"+data.data[i].name+"吗?','"+data.data[i].id+"');\">删除</a>"
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


