<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/css; charset=UTF-8"/>
    <title>Strona Główna | Kalkulator Prowizji</title>
    <link rel="stylesheet" href="<c:url value="/resources/static/css/style.css"/>" type="text/css"/>
</head>
<body>
<div class="tt">
    Podaj: numer ticketa (razem z TT), numer logowy lub numer klienta<br/>
    <form:form method="post" action="/ticketapp/view">
        <input type="text" name="id"><br/>
        <input type="submit" value="Zobacz tt">
    </form:form><br/>
    <form:form method="get" action="/ticketapp/add">
        <input type="submit" value="Dodaj ticket">
    </form:form><br/>
</div>

<div class="logout">
    <sec:authorize access="isAuthenticated()">
        <form:form method="get" action="/targetadd">
            <input type="submit" value="Prowizja Miesięczna / Target">
        </form:form>

        <form:form method="get" action="/app/useradd">
            <input type="submit" value="Dodaj Sprzedaż">
        </form:form>

        <form:form method="post" action="/logout">
            <input type="submit" value="Wyloguj"></form:form>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <form:form method="get" action="/index">
            <input type="submit" value="Strona Glowna"></form:form>
    </sec:authorize>
    <sec:authorize access="hasAnyRole('ROLE_LEADER')">
        <form:form method="get" action="/leader/app">
            <input type="submit" value="Aplikacja dla leaderów">
        </form:form>
    </sec:authorize>
</div>


</body>
</html>
