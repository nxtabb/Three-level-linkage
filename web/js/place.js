$(document).ready(function () {
var province = $("#province");
var city = $("#city");
var qu = $("#qu");
province.change(function () {
    $.ajax({
        url:"/place",
        type:"POST",
        dataType:"JSON",
        data:"content=province&province_id="+province.val(),
        success:function (data) {
            var content ="";
            for(var i=1;i<data.length-data[0];i++){
                content+="<option value='"+data[i].city_id+"'>"+data[i].city_name+"</option>";
            }
            city.html(content);
            content = "";
            for(var j=data.length-data[0];j<data.length;j++){
                content+="<option value='"+data[j].qu_id+"'>"+data[j].qu_name+"</option>";
            }
            qu.html(content);
            content="";
        }

    })

})
city.change(function () {
    $.ajax({
        url:"/place",
        type:"POST",
        dataType:"JSON",
        data:"content=city&city_id="+city.val(),
        success:function (data) {
            var content1 ="";
            for(var i=0;i<data.length;i++){
                content1+="<option value='"+data[i].qu_id+"'>"+data[i].qu_name+"</option>";
            }
            qu.html(content1);
            content1 = ""
        }

    })

})


})