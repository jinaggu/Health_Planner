$(document).ready(function() {

    $("#searchBtn").click(function() {
        let searchVal = $("#searchVal").val();
        $("#modalVal").text(searchVal);
        let data = {
            foodName : searchVal
        }

        debugger;
        $.ajax({
            dataType: "json",
            type : "get",
            url : '/mealRecord/getFoodCalorieInfo',
            data : data,
            success : function(res) {
                console.log(res)
                for (let i = 0; i < res.length; i++) {
                    $("#tbody").append("<tr>" + "<td><input type='checkbox'></td>" +
                    "<td scope='row'>"+res[i].food_NM+"</td><td>"+res[i].nutr_CONT1+"</td>"+
                    "</tr>");
                }
            },
            error : function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });

    });

});


