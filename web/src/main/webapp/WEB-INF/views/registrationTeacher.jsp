<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/faculty-ico.jpg">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <link rel="stylesheet" href="/resources/css/add.css"/>
    <title>Registration Page</title>
</head>
<body>

<div class="wrapper">

    <c:import url="/WEB-INF/views/header.jsp"/>

    <div id="content">

        <br/>

        <div class="errTest">
            <p style="padding-left: 90px;">ПРЕПОДАВАТЕЛЬ</p><br/>

            <form:form method="post" modelAttribute="user" action="/registrationTeacher">
                <spring:bind path="username">
                    <form:input path="username" type="text" placeholder="Username" class="addInput"/>
                    <form:errors path="username" cssStyle="color: red"/>
                </spring:bind><br/><br/>
                <spring:bind path="password">
                    <form:input path="password" type="text" placeholder="Password" class="addInput"/>
                    <form:errors path="password" cssStyle="color: red"/>
                </spring:bind><br/><br/>
                <button type="submit" class="addButton">Регистрация</button>
            </form:form>

        </div>

    </div>

    <c:import url="/WEB-INF/views/footer.jsp"/>

</div>

</body>
</html>


