<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/faculty-ico.jpg">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <link rel="stylesheet" href="/resources/css/navigation.css"/>
    <link rel="stylesheet" href="/resources/css/table-admin.css"/>
    <title>Admin All Teachers Page</title>
</head>
<body>

<div class="wrapper">

    <c:import url="/WEB-INF/views/header.jsp"/>

    <div id="content">

        <ul>
            <li><a href="/admin/allRoles">Роли</a></li>
            <li><a href="/admin/allCourses">Курсы</a></li>
            <li><a href="/admin/allStudentsPagination/1">Студенты</a></li>
            <li><a href="/admin/allTeachers" class="active">Преподаватели</a></li>
        </ul>

        <br/>

        <table>
            <caption>Список преподавателей</caption>
            <tr>
                <th>user_id</th>
                <th>username</th>
                <th>password</th>
            </tr>
            <c:forEach var="t" items="${teachers}">
                <tr>
                    <td><c:out value="${t.user_id}"/></td>
                    <td><c:out value="${t.username}"/></td>
                    <td><c:out value="${t.password}"/></td>
                </tr>
            </c:forEach>
        </table>

    </div>

    <c:import url="/WEB-INF/views/footer.jsp"/>

</div>

</body>
</html>














