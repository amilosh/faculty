<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <
    <title>Error 500 Page</title>
</head>
<body>

<div class="errorpage">
    <div class="pagenotfound"><spring:message code="AnErrorHasOccurred"/></div>
    <div class="errorcat"><img src="${pageContext.request.contextPath}/resources/images/error_cat.jpg"></div>
</div>

</body>
</html>



