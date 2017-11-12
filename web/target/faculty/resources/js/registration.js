$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

function  checkAfterChangeUsername() {
    var userRequest = {};
    userRequest["username"] = $("#username").val();

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "checkUsername",
        data : JSON.stringify(userRequest),
        dataType : 'json',
        success : function(result) {
            if(result.message == "true") {
                $("#errorUsername").show();
            } else if(result.message == "false") {
                $("#errorUsername").hide();
            }

        },
        error : function(e) {
            alert("Error!");
            console.log("ERROR: ", e);
        }
    });

}