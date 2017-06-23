<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/faculty-ico.jpg">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <title>Admin All UserCourses Page</title>
</head>
<body>

<div class="wrapper">

    <c:import url="/WEB-INF/views/header.jsp"/>

    <div id="content">

        <p><a href="/admin/allRoles">Список всех ролей</a></p>
        <p><a href="/admin/allCourses">Список всех курсов</a></p>
        <p><a href="/admin/allStudentsPagination/1">Список всех студентов</a></p>
        <p><a href="/admin/allTeachers">Список всех преподавателей</a></p>
        <p>Список все юзер-курсы</p>

        <hr/>

        <p><b>Список юзер-курсов:</b></p>
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>user_course_id</th>
                <th>user</th>
                <th>course</th>
                <th>rating</th>
            </tr>
            <c:forEach var="uc" items="${userCourses}">
                <tr>
                    <td><c:out value="${uc.user_course_id}" />
                    <td><c:out value="${uc.user.username}" />
                    <td><c:out value="${uc.course.courseName}" />
                    <td><c:out value="${uc.rating}" />
                <tr />
            </c:forEach>
        </table>

    </div>

    <c:import url="/WEB-INF/views/footer.jsp"/>

</div>

</body>
</html>













