<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../css.jsp"/>
    <title><spring:message code="MainPage"/></title>
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


