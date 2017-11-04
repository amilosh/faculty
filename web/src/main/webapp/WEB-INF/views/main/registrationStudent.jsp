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
    <script type="text/javascript" src="${contextPath}/resources/js/registration.js">

    </script>
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
                <spring:bind path="username">
                    <form:input path="username" type="text" placeholder="Username" class="addInput" id="username"/>
                    <form:errors path="username" cssStyle="color: red"/>
                </spring:bind><br/><br/>
                <spring:bind path="password">
                    <form:input path="password" type="text" placeholder="Password" class="addInput"/>
                    <form:errors path="password" cssStyle="color: red"/>
                </spring:bind><br/><br/>
                <button type="submit" class="addButton">Регистрация</button>
            </form:form><br/>

        </div>

    </div>

    <c:import url="/WEB-INF/views/main/footer.jsp"/>

</div>

</body>
</html>

