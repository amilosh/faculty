function  myFunction() {
    alert("1. начало функции");
    var formData = {
        username : $("#username").val()
    };
    alert("formData.username" + formData.username);

    alert("1.1. начало функции");
    var x = document.getElementById("username").value;
    alert("2. иксу присвоили значение");
    document.getElementById("demo").innerHTML = "You wrote: " + x;
    alert("3. элементу присвоили значение икса");

    // PREPARE FORM DATA
    //var formData = {
    //    username : $("#username").val()
    //}
    //
    //alert("formData.username" + formData.username);
    // DO POST
    $.ajax({
        type : "POST",
        contentType : "application/json",
        //url : window.location + "api/customer/save",
        //url : '${pageContext.request.contextPath}' + "/api/customer/save",
        url : "http://localhost:8080/api/customer/save",
        data : JSON.stringify(formData),
        dataType : 'json',
        success : function(result) {
            if(result.status == "Done"){
                $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                "Post Successfully! <br>" +
                "---> Customer's Info: username = " + result.data.username);
            }else{
                $("#postResultDiv").html("<strong>Error</strong>");
            }
            console.log(result);
        },
        error : function(e) {
            alert("Error!");
            console.log("ERROR: ", e);
        }
    });

}