$(document).ready(function() {

    $("#searchBtn").click(function() {
        let searchVal = $("#searchVal").val();
        $("#modalVal").text(searchVal);

        if (searchVal == "" || searchVal == null) {
            alert("검색어를 입력해주세요.");
            return false;
        }

        let data = {
            foodName : searchVal
        }

        $.ajax({
            dataType: "json",
            type : "get",
            url : '/mealRecord/getFoodCalorieInfo',
            data : data,
            success : function(res) {
                console.log(res)
                for (let i = 0; i < res.length; i++) {
                    $("#tbody").append("<tr>" + "<td><input type='checkbox' name='check'></td>" +
                    "<td scope='row'>"+res[i].food_NM+"</td><td>"+res[i].nutr_CONT1+"</td>"+
                    "<td style='display:none;'><input type='hidden' value='" + res[i].food_CD + "'></td>" +
                    "</tr>");
                }
            },
            error : function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });

    });

    $("#calAdd").click(function() {

    });


});


