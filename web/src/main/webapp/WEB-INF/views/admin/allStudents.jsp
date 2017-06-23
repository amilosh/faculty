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
    <link rel="stylesheet" href="/resources/css/pagination.css"/>
    <title>Admin All Students Page</title>
</head>
<body>

<div class="wrapper">

    <c:import url="/WEB-INF/views/header.jsp"/>

    <div id="content">

        <ul>
            <li><a href="/admin/allRoles">Роли</a></li>
            <li><a href="/admin/allCourses">Курсы</a></li>
            <li><a href="/admin/allStudentsPagination/1" class="active">Студенты</a></li>
            <li><a href="/admin/allTeachers">Преподаватели</a></li>
        </ul>

        <br/>

        <table>
            <caption>Список студентов</caption>
            <tr>
                <th>user_id</th>
                <th>username</th>
                <th>password</th>
            </tr>
            <c:forEach var="s" items="${students}">
                <tr>
                    <td><c:out value="${s.user_id}" /></td>
                    <td><c:out value="${s.username}" /></td>
                    <td><c:out value="${s.password}" /></td>
                </tr>
            </c:forEach>
        </table>

        <br/><br/>

        <c:if test="${currentPage != 1}">
            <td><a href="/admin/allStudentsPagination/${currentPage - 1}" class="prev"> Previous </a></td>
        </c:if>

        <c:forEach begin="1" end="${numberOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <span class="currentPage">${i}</span>
                </c:when>
                <c:otherwise>
                    <a href="/admin/allStudentsPagination/${i}" class="page">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt numberOfPages}">
            <td><a href="/admin/allStudentsPagination/${currentPage + 1}" class="next"> Next </a> </td>
        </c:if>

    </div>

    <c:import url="/WEB-INF/views/footer.jsp"/>

</div>

</body>
</html>





















