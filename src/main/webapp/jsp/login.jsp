<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/css; charset=UTF-8"/>
    <title>Zaloguj się | Kalkulator Prowizji</title>
    <link rel="stylesheet" href="<c:url value="/resources/static/css/style.css"/>" type="text/css"/>

    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
</head>
<body>
<div class="relation">
    <form:form method="post" action="login" modelAttribute="user">
        <input type="text" name="username" placeholder="Username" required/><br/><br/>
        <input type="password" name="password" placeholder="Password" required/><br/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Zaloguj"/>
    </form:form><br/>

    <form:form method="get" action="register">
        <input type="submit" value="Zarejestruj"></form:form><br/>
    Test acc: test/131<br/>

</div>
<div class="relation">
    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
        Nieudane Logowanie
    </c:if>
</div>

</body>
</html>