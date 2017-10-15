<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../css.jsp"/>
    <title>Personal Teacher Page</title>
</head>
<body>

<div class="wrapper">

    <c:import url="/WEB-INF/views/main/header.jsp"/>

    <div id="content">

        <c:choose>

            <c:when test="${empty userCourses}">
                <form:form method="post" modelAttribute="course" action="${contextPath}/personalTeacher">
                    <table>
                        <caption>Выберите курс для преподавания</caption>
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
                    <button type="submit" class="tableSubmitTeacher">Выбрать курс</button>
                </form:form><br/>
                ${check}
            </c:when>

            <c:when test="${not empty userCourses}">
                <p>Ваш курс преподавания: <b>${userCourses[0].course.courseName}</b>.</p>

                <br/><br/>

                <table class="teacherTable">
                    <caption>Список студентов вашего курса</caption>
                    <tr>
                        <th class="stName">Имя студента</th>
                        <th class="stRating">Оценка</th>
                        <th colspan="2" class="doRating">Поставить оценку</th>
                    </tr>
                    <c:forEach var="sl" items="${studentsList}" >
                        <form:form method="post" action="${contextPath}/makeAsses">
                            <tr>
                                <td><c:out value="${sl.user.username}" /></td>
                                <td class="stRatingRow"><c:out value="${sl.rating}" /></td>
                                <td class="stDoRating">
                                    <c:choose>
                                        <c:when test="${empty sl.rating}">
                                            <input type="int" name="rating" class="inputRating">
                                        </c:when>
                                        <c:when test="${not empty sl.rating}">

                                        </c:when>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${empty sl.rating}">
                                            <input type="hidden" name="userCourseId" value="${sl.userCourseId}">
                                            <button type="submit">Поставить оценку</button>
                                        </c:when>
                                        <c:when test="${not empty sl.rating}">

                                        </c:when>
                                    </c:choose>
                                </td>
                            </tr>
                        </form:form>
                    </c:forEach>
                </table>
            </c:when>

            <c:otherwise>
                <p>userCourses otherwise</p>
            </c:otherwise>

        </c:choose>

    </div>

    <c:import url="/WEB-INF/views/main/footer.jsp"/>

</div>

</body>
</html>
































