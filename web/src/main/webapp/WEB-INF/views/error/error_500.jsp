<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${contextPath}/resources/css/error.css"/>
    <title>Error 500 Page</title>
</head>
<body>

<div class="errorpage">
    <div class="pagenotfound"><spring:message code="AnErrorHasOccurred"/></div>
    <div class="errorcat"><img src="${contextPath}/resources/images/error_cat.jpg"></div>
</div>

</body>
</html>



