<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/css; charset=UTF-8"/>
    <title>Strona Główna| Kalkulator Prowizji</title>
    <link rel="stylesheet" href="<c:url value="/resources/static/css/style.css"/>" type="text/css"/>
</head>
<body>
<div class="tt">
    <form:form method="get" action="/app/">
        <input type="submit" value="Wersja dla Uzytkownika">
    </form:form><br/>

    <form:form method="get" action="/leader/getdatabase">
        <input type="submit" value="Baza danych - pojedyńczy pracownik">
    </form:form><br/>


    <form:form method="post" action="/leader/getteam">
        <input type="submit" value="Baza danych - cały team">
    </form:form><br/>

</div>
<div class="logout">
    <sec:authorize access="isAuthenticated()">
        <form:form method="post" action="/logout">
            <input type="submit" value="Wyloguj"></form:form>
    </sec:authorize>
</div>


</body>
</html>
