<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="shortcut icon" type="image/x-icon" href="${contextPath}/resources/images/faculty-ico.jpg">
    <link rel="stylesheet" href="${contextPath}/resources/css/main.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/registration.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/add.css"/>
    <title><spring:message code="RegistrationPage"/></title>
</head>
<body>

<div class="wrapper">

    <c:import url="/WEB-INF/views/main/header.jsp"/>

    <div id="content">

        <div class="reg">
            <table class="tableReg">
                <tr>
                    <td colspan="2" class="treg"><spring:message code="REGISTRATION"/></td>
                </tr>
                <tr>
                    <td class="stud"><a href="${contextPath}/registrationStudent"><spring:message code="STUDENT"/></a>
                    </td>
                    <td class="teach"><a href="${contextPath}/registrationTeacher"><spring:message code="TEACHER"/></a>
                    </td>
                </tr>
            </table>
        </div>

    </div>

    <c:import url="/WEB-INF/views/main/footer.jsp"/>

</div>

</body>
</html>

