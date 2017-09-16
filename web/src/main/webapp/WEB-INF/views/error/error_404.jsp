<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../css.jsp"/>
    <title>Error 404 Page</title>
</head>
<body>

    <div class="errorpage">
        <div class="pagenotfound"><spring:message code="PageNotFound"/></div>
        <div class="errorcat"><img src="${pageContext.request.contextPath}/resources/images/error_cat.jpg"></div>
    </div>

</body>
</html>


