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
                console.log(res);
                for (let i = 0; i < res.length; i++) {
                    $("#tbody").append("<tr>" + "<td><input type='checkbox' name='check'></td>" +
                    "<td scope='row'>"+res[i].food_NM+"</td><td>"+res[i].nutr_CONT1+"</td>"+
                    "<td style='display:none;'>" + res[i].food_CD + "</td>" +
                    "</tr>");
                }
            },
            error : function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });

    });

    $("#calAdd").click(function() {

        let str = "";
        let tdArr = new Array(); // 배열 선언

        let checkBox = $("input:checkbox[name=check]:checked");
        checkBox.each(function(i) {
            let tr = checkBox.parent().parent().eq(i);
            let td = tr.children();

            let calObj = {};
            calObj.name = td.eq(1).text();
            calObj.cal = td.eq(2).text();
            calObj.cd = td.eq(3).text();
            calObj.mealType = "M";

            tdArr.push(calObj);
        });

        let jsonData = JSON.stringify(tdArr);

        $.ajax({
            //dataType : "json",
            type : "post",
            url : '/mealRecord/addCalories',
            data : {checkBox : jsonData},
            success : function() {
                $("#myModal").modal("hide");
                window.location.href = "/mealRecord/mealRecord";
                alert("11");
            },
            error : function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });

    });

    $("#del").click(function() {
        let str = "";
        let tdArr = new Array(); // 배열 선언

        let checkBox = $("input:checkbox[name=chk]:checked");
        checkBox.each(function(i) {
            let tr = checkBox.parent().parent().eq(i);
            let td = tr.children();
            tdArr.push(td.eq(3).text()); // idx
        });

        $.ajax({
            type : "get",
            url : '/mealRecord/delCalories',
            data : {idx : tdArr},
            success : function() {
                window.location.href = "/mealRecord/mealRecord";
                console.log("del");
            },
            error : function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });

    });


});


