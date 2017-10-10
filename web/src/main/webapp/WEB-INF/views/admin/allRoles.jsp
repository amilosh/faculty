<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../css.jsp"/>
    <title><spring:message code="AdminAllRolesPage"/></title>
</head>
<body>

<div class="wrapper">

    <c:import url="/WEB-INF/views/main/header.jsp"/>

    <div id="content">

        <ul>
            <li><a href="${contextPath}/admin/allRoles" class="active"><spring:message code="Roles"/></a></li>
            <li><a href="${contextPath}/admin/allCourses"><spring:message code="Courses"/></a></li>
            <li><a href="${contextPath}/admin/allStudentsPagination/1"><spring:message code="Students"/></a></li>
            <li><a href="${contextPath}/admin/allTeachersPagination/1"><spring:message code="Teachers"/></a></li>
        </ul>

        <br/>

        <table>
            <caption><spring:message code="ListOfRoles"/></caption>
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

        <form:form name="addRole" method="post" action="${contextPath}/admin/allRoles">
            <input type="text" name="title" value="" placeholder="<spring:message code="RoleName"/>" class="addInput"><br/><br/>
            <input type="submit" class="addButton" value="<spring:message code="AddRole"/>">
        </form:form>

    </div>

    <c:import url="/WEB-INF/views/main/footer.jsp"/>

</div>

</body>
</html>
