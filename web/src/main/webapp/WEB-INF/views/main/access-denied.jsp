<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/faculty-ico.jpg">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <meta charset="utf-8">
    <title>Access denied</title>
</head>
<body>

<div class="wrapper">

    <header>
        <span class="logo">
            <a href="/"><img src="/resources/images/logo.jpg"></a>
        </span>
        <span class="ruen">RU EN</span>
    </header>

    <div id="content">

        Пользователь ${pageContext.request.userPrincipal.name}, доступ к этой странице вам запрещён.

        <br/><br/>

        <img src="/resources/images/sadcat.jpg"><br/><br/>

        <a href="/">На главную</a>

    </div>

    <c:import url="footer.jsp"/>

</div>

</body>
</html>
