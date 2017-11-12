<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${contextPath}/resources/css/main.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/add.css"/>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/js/registration.js"></script>

    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title>Registration Page</title>
</head>
<body>

<div class="wrapper">

    <c:import url="/WEB-INF/views/main/header.jsp"/>

    <div id="content">

        <br/>

        <div class="errTest">
            <p style="padding-left: 120px;">СТУДЕНТ</p><br/>

            <form:form method="post" modelAttribute="user" action="${contextPath}/registrationStudent">
                <div class="usernameDiv">
                    <spring:bind path="username">
                        <form:input path="username" type="text" placeholder="Username" class="addInput" id="username" name="username" oninput="checkAfterChangeUsername()"/>
                        <form:errors path="username" cssStyle="color: red"/>
                    </spring:bind>
                </div>
                <div class="errorUsernameDiv" id="errorUsername" style="display: none">
                    <span style="color: red"><spring:message code="user.username.exist"/></span>
                </div>
                <div class="passwordDiv">
                    <spring:bind path="password">
                        <form:input path="password" type="text" placeholder="Password" class="addInput"/>
                        <form:errors path="password" cssStyle="color: red"/>
                    </spring:bind>
                </div>
                <div class="buttonDiv">
                    <button type="submit" class="addButton">Регистрация</button>
                </div>
            </form:form><br/>

        </div>

    </div>

    <c:import url="/WEB-INF/views/main/footer.jsp"/>

</div>

</body>
</html>

