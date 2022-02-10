$(document).ready(function() {

    let url = '/mealRecord/memberInfoSave';

    $("#memberInfoSave").click(function() {
        let mid = $("#mid").val();
        if (mid == '' || mid == null) {
            alert("로그인 시간이 만료되었습니다. 다시 로그인해주세요.");
            location.href = '/member/loginPage';
        }

        let formData = new FormData($('#form')[0]);
        let height = formData.get('height');
        let weight = formData.get('weight');

        if (height == '' || weight == '') {
            alert("몸무게, 키를 입력해주세요.");
            return false;
        }

        let bmi = createBmi(height,weight);
        let gender = $("input[name=btnradio]:checked").val();
        formData.append("gender", gender);
        formData.append("bmi", bmi);

        $.ajax({
            method: "POST",
            url : url,
//            dataType : "json", // 서버에서 반환하는 타입임
            data : formData,
            processData : false,
            contentType : false,
            success : function(data) {
                alert("기본정보가 저장되었습니다.");
                $("#dateOfBirth").attr("disabled", true);
                $("#height").attr("disabled", true);
                $("#weight").attr("disabled", true);
                $("#memberInfoSave").val("기본정보 수정");
                $("#bmiInfo").addClass('progress text-center');
                $("#bmiInfo").css({"width" : "50%", "height" : "25px"});
                $("#bmiInfo").append("<div class='progress-bar progress-bar-striped bg-warning' role='progressbar' style='width :" + bmi +
                "%;>0/0 kcal</div>"); /*+ ("<br/><h5>당신의 bmi 수치는 <strong>" + bmi + "</strong> 입니다.</h5>")*/

            },
            error: function(xhr, content, s) {
                console.log(content);
            }
        });
    });

    function createBmi(height, weight) {
        let bmi = (weight/((height / 100) * (height / 100))).toFixed(1);
        return bmi;
    }

});


