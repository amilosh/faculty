<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/faculty-ico.jpg">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <link rel="stylesheet" href="/resources/css/navigation.css"/>
    <link rel="stylesheet" href="/resources/css/table-admin.css"/>
    <link rel="stylesheet" href="/resources/css/add.css"/>
    <title>Admin All Roles Page</title>
</head>
<body>

<div class="wrapper">

    <c:import url="/WEB-INF/views/header.jsp"/>

    <div id="content">

        <ul>
            <li><a href="/admin/allRoles" class="active">Роли</a></li>
            <li><a href="/admin/allCourses">Курсы</a></li>
            <li><a href="/admin/allStudentsPagination/1">Студенты</a></li>
            <li><a href="/admin/allTeachers">Преподаватели</a></li>
        </ul>

        <br/>

        <table>
            <caption>Список ролей</caption>
             <tr>
                <th>role_id</th>
                <th>role_name</th>
            </tr>
            <c:forEach var="r" items="${roles}">
                <tr>
                    <td><c:out value="${r.role_id}" /></td>
                    <td><c:out value="${r.roleName}" /></td>
                </tr>
            </c:forEach>
        </table>

        <br/>

        <form:form name="addRole" method="post" action="/admin/allRoles">
            <input type="text" name="title" value="" placeholder="Название роли" class="addInput"><br/><br/>
            <input type="submit" class="addButton" value="Добавить роль">
        </form:form>

    </div>

    <c:import url="/WEB-INF/views/footer.jsp"/>

</div>

</body>
</html>
