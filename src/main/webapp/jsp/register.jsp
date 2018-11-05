<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/css; charset=UTF-8"/>
    <title>Zarejestruj się | Kalkulator Prowizji</title>
    <link rel="stylesheet" href="<c:url value="/resources/static/css/style.css"/>" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
</head>
<body>
${x}
<div class="relation">
    <form:form method="post" action="register" modelAttribute="user">
        <input type="text" name="username" placeholder="Username" required/><br/>
        <input type="password" name="password" placeholder="Hasło" required/><br/>
        <input type="password" name="password2" placeholder="Powtórz Haslo" required/><br/>
        <input type="text" name="mail" placeholder="E-mail" required/><br/>
        <input type="text" name="leader" placeholder="id lidera" required/><br/>
        <input type="submit" value="Zarejestruj"/>
    </form:form><br/>
    <form:form method="get" action="index">
        <input type="submit" value="Strona Główna">
    </form:form><br/>
    ID Leaderow:<br/>
    leader1<br/>
    leader2<br/>
</div>

</body>
</html>
