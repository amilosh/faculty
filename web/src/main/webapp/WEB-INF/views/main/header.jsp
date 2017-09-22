<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

    <header>

        <span class="logo">
            <a href="${contextPath}/"><img src="${contextPath}/resources/images/logo.jpg"></a>
        </span>

        <span class="ruen"><a href="?lang=en_US"><img src="${contextPath}/resources/images/UK.jpg"></a> <a href="?lang=ru_RU"><img src="${contextPath}/resources/images/RUS.jpg"></a>  </span>

        <span class="enter">
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.name != null}">
                    <a href="${contextPath}/personal"><spring:message code="personalPage"/> ${pageContext.request.userPrincipal.name}</a> | <a href="${contextPath}/logout"><spring:message code="logout"/> </a>
                </c:when>
                <c:otherwise>
                    <a href="${contextPath}/login"><spring:message code="logIn"/> </a> | <a href="${contextPath}/registration"><spring:message code="logUp"/> </a>
                </c:otherwise>
            </c:choose>
        </span>

    </header>

</html>
