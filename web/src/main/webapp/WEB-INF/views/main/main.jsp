<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/faculty-ico.jpg">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <title>Main Page</title>
</head>
<body>

<div class="wrapper">

    <c:import url="header.jsp"/>

    <div id="content">
        <div class="welcome"><spring:message code="welcome"/></div>
    </div>

    <c:import url="footer.jsp"/>

</div>

</body>
</html>


