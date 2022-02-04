$(document).ready(function() {

    var dagim_yn = $("#flexCheckDefault").val();

    if(dagim_yn == "Y") {
        $("#flexCheckDefault").prop("checked", true);
    }

    $("#save").click(function() {
        if ($("#flexCheckDefault").is(":checked")) {
            $("#dagim_yn").val("Y");
        } else {
            $("#dagim_yn").val("N");
        }
        alert("회원정보 수정이 완료되었습니다.")
    });
});


