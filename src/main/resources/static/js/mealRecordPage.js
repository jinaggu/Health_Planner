$(document).ready(function() {
    let _today = new Date();

    let year = _today.getFullYear(); // 년도
    let month = _today.getMonth() + 1; // 월
    let date = _today.getDate(); // 날짜

    let today = year + "년 " + month + "월 " + date + "일 ";

    $("#today").text(today);

});


