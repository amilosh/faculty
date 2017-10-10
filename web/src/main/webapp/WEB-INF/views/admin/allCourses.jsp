<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../css.jsp"/>
    <title><spring:message code="AdminAllCoursesPage"/></title>
</head>
<body>

<div class="wrapper">

    <c:import url="/WEB-INF/views/main/header.jsp"/>

    <div id="content">

        <ul>
            <li><a href="${contextPath}/admin/allRoles"><spring:message code="Roles"/></a></li>
            <li><a href="${contextPath}/admin/allCourses" class="active"><spring:message code="Courses"/></a></li>
            <li><a href="${contextPath}/admin/allStudentsPagination/1"><spring:message code="Students"/></a></li>
            <li><a href="${contextPath}/admin/allTeachersPagination/1"><spring:message code="Teachers"/></a></li>
        </ul>

        <br/>

        <table>
            <caption><spring:message code="ListOfCourses"/></caption>
            <tr>
                <th>course_id</th>
                <th>courseName</th>
            </tr>
            <c:forEach var="c" items="${courses}">
                <tr>
                    <td><c:out value="${c.course_id}" /></td>
                    <td><c:out value="${c.courseName}" /></td>
                </tr>
            </c:forEach>
        </table>

        <br/>

        <form:form name="addCourse" method="post" action="${contextPath}/admin/allCourses">
            <input type="text" name="title" value="" placeholder="<spring:message code="CourseName"/>" class="addInput"><br/><br/>
            <input type="submit" class="addButton" value="<spring:message code="AddCourse"/>">
        </form:form>

    </div>

    <c:import url="/WEB-INF/views/main/footer.jsp"/>

</div>

</body>
</html>






