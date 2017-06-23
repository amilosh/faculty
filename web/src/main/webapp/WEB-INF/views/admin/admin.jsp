<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/faculty-ico.jpg">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <link rel="stylesheet" href="/resources/css/navigation.css"/>
    <title>Admin Main Page</title>
</head>
<body>

<div class="wrapper">

    <c:import url="/WEB-INF/views/header.jsp"/>

    <div id="content">

        <ul>
            <li><a href="/admin/allRoles">Роли</a></li>
            <li><a href="/admin/allCourses">Курсы</a></li>
            <li><a href="/admin/allStudentsPagination/1">Студенты</a></li>
            <li><a href="/admin/allTeachers">Преподаватели</a></li>
        </ul>

    </div>

    <c:import url="/WEB-INF/views/footer.jsp"/>

</div>

</body>
</html>
