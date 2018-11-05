<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Wynik | Kalkulator Prowizji</title>
    <link rel="stylesheet" href="<c:url value="/resources/static/css/style.css"/>" type="text/css"/>
</head>
<body>

<div class="relation">
<p>Dodano: </p>
<p>Logowy:          ${detali.log} </p>
<p>ID Klienta:      ${detali.clientid} </p>
<p>Różnica Ceny:    ${detali.darpu} </p>
<p>Segment:         ${detali.segment} </p>
<p>Rekomendowane:   ${detali.recomended} </p>
<p>Okres Loj:       ${detali.okresloj} </p>
<p>Lojalizowano:    ${detali.loj} </p>
<p>Produkt miesiąca ${detali.msc}</p>
<p>Utarg:           ${utarg}</p>
</div>
<div class="logout">
    <sec:authorize access="isAuthenticated()">


        <form:form method="get" action="/ticketapp">
            <input type="submit" value="Aplikacja Ticketowa">
        </form:form>


        <form:form method="get" action="/app/getdeals">
            <input type="submit" value="Obecna Prowizja - Wymaga Zalogowani">
        </form:form>

        <form:form method="get" action="/targetadd">
            <input type="submit" value="Prowizja Miesięczna / Target">
        </form:form>

        <form:form method="get" action="/app/useradd">
            <input type="submit" value="Dodaj Sprzedaż">
        </form:form>

        <form:form method="post" action="/logout">
            <input type="submit" value="Wyloguj"></form:form><br/>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <form:form method="get" action="index">
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