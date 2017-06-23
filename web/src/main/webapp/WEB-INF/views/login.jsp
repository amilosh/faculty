<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" type="image/x-icon" href="/resources/images/faculty-ico.jpg">
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <link rel="stylesheet" href="/resources/css/login.css"/>
    <link rel="stylesheet" href="/resources/css/form.css"/>
    <title>Login Page</title>
</head>
<body>

<div class="wrapper">

    <header>
        <span class="logo">
            <a href="/"><img src="/resources/images/logo.jpg"></a>
        </span>
        <span class="ruen">RU EN</span>
    </header>

    <div id="content">

        <div id="authform">
            <div class="authwrapper">
                <form class="form" method="post" action="/login">

                    <div class="hold">
                        <input type="text" name="username" placeholder="Username" class="inputlogin">
                    </div>

                    <div class="hold">
                        <input type="text" name="password" placeholder="Password" class="inputpassword">
                    </div>

                    <div class="enterform">
                        <div class="enterdiv">
                            <button type="submit" class="entersubmit">Войти</button>
                        </div>
                        <div class="remdiv">
                            <input type="checkbox" name="rememberme" class="rememberme">
                            <label for="rememberme" class="remembermelabel">Запомнить</label>
                        </div>
                    </div>

                    <div class="formError">
                        <c:if test="${not empty error}">
                            ${error}
                        </c:if>
                    </div>

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>

    </div>

    <c:import url="footer.jsp"/>

</div>

</body>
</html>
