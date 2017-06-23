<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/faculty-ico.jpg">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <link rel="stylesheet" href="/resources/css/add.css"/>
    <link rel="stylesheet" href="/resources/css/registration.css"/>
    <title>Registration Page</title>
</head>
<body>

<div class="wrapper">

    <c:import url="/WEB-INF/views/header.jsp"/>

    <div id="content">

        <div class="reg">
            <table class="tableReg">
                <tr>
                    <td colspan="2" class="treg">РЕГИСТРАЦИЯ</td>
                </tr>
                <tr>
                    <td class="stud"><a href="/registrationStudent">СТУДЕНТ</a></td>
                    <td class="teach"><a href="/registrationTeacher">ПРЕПОДАВАТЕЛЬ</a></td>
                </tr>
            </table>
        </div>

    </div>

    <c:import url="/WEB-INF/views/footer.jsp"/>

</div>

</body>
</html>

