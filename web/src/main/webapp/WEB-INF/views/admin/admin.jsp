<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../css.jsp"/>
    <title><spring:message code="AdminMainPage"/></title>
</head>
<body>

<div class="wrapper">

    <c:import url="/WEB-INF/views/main/header.jsp"/>

    <div id="content">

        <ul>
            <li><a href="/admin/allRoles"><spring:message code="Roles"/></a></li>
            <li><a href="/admin/allCourses"><spring:message code="Courses"/></a></li>
            <li><a href="/admin/allStudentsPagination/1"><spring:message code="Students"/></a></li>
            <li><a href="/admin/allTeachersPagination/1"><spring:message code="Teachers"/></a></li>
        </ul>

    </div>

    <c:import url="/WEB-INF/views/main/footer.jsp"/>

</div>

</body>
</html>
