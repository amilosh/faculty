<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../css.jsp"/>
    <meta charset="utf-8">
    <title><spring:message code="AccessDenied"/></title>
</head>
<body>

<div class="wrapper">

    <c:import url="header.jsp"/>

    <div id="content">

        <spring:message code="User"/> ${pageContext.request.userPrincipal.name}, <spring:message code="accessToThisPageIsDeniedForYou."/>

        <br/><br/>

        <img src="${pageContext.request.contextPath}/resources/images/sadcat.jpg"><br/><br/>

        <a href="/"><spring:message code="ToMainPage"/></a>

    </div>

    <c:import url="footer.jsp"/>

</div>

</body>
</html>
