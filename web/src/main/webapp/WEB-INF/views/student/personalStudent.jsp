<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../css.jsp"/>
    <title>Personal Student Page</title>
</head>
<body>

<div class="wrapper">

    <c:import url="/WEB-INF/views/main/header.jsp"/>

        <div id="content">

            <table>
                <caption>Список ваших курсов</caption>
                <tr>
                    <th>Название курса</th>
                    <th>Ваша оценка</th>
                </tr>
                <c:forEach var="uc" items="${userCourses}" >
                    <tr>
                        <td><c:out value="${uc.course.courseName}" /></td>
                        <td class="tableRating"><c:out value="${uc.rating}" /></td>
                    </tr>
                </c:forEach>
            </table>

            <br/><br/>

            <form:form method="post" modelAttribute="course" action="/personalStudent">
                <table>
                    <caption>Записаться на новый курс</caption>
                    <tr>
                        <th>Название курса</th>
                    </tr>
                    <c:forEach var="cN" items="${courseNames}" >
                        <tr>
                            <td>
                                <spring:bind path="courseName">
                                    <form:radiobutton path="courseName" value="${cN}" id="${cN}"/>
                                    <label for="${cN}">${cN}</label>
                                </spring:bind>
                            </td>
                        </tr>
                    </c:forEach>
                </table><br/>
                <button type="submit" class="tableSubmit">Записаться</button><br/><br/>
                <form:errors cssStyle="color: red"/>
            </form:form><br/>
            ${check}

        </div>

    <c:import url="/WEB-INF/views/main/footer.jsp"/>

</div>

</body>
</html>

