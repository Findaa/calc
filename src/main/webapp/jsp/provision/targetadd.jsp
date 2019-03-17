<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/css; charset=UTF-8"/>
    <title>Podaj Dane | Kalkulator Prowizji</title>
    <link rel="stylesheet" href="<c:url value="/resources/static/css/style.css"/>" type="text/css"/>
</head>
<body>




<div class="relation">
    <p>
        <form:form name="targetadd" method="post" action="/targetadd" modelAttribute="target" >
    <p id="loginpagelabel">Podaj dane</p>
    <d>Target FCR</d>
    <br/>
    <input type="text" name="fcr" placeholder="Target FCR" required/>
    <input type="text" name="cfcr" placeholder="Obecny FCR" required/><br/>
    <d>Target NPS</d>
    <br/>
    <input type="text" name="nps" placeholder="Target NPS" required/>
    <input type="text" name="cnps" placeholder="Obecny NPS" required/><br/>
    <d>Target Upgrade</d>
    <br/>
    <input type="text" name="upgrade" placeholder="Target Upgrade" required/>
    <input type="text" name="cupgrade" placeholder="Obecny Upgrade" required/><br/>
    <d>Target Premium</d>
    <br/>
    <input type="text" name="premium" placeholder="Target Premium" required/>
    <input type="text" name="cpremium" placeholder="Obecny Premium" required/><br/>
    <d>Suma</d><d>Sprzedazy</d>
    <br/>
    <input type="text" name="arpu" placeholder="Suma Sprzedazy" onchange="this.value = this.value.replace(',', '.')" value="${total}"/><br/>
    <input type="submit" value="Przelicz"/>
    </form:form>
    </p><br/>
</div>

<div class="logout">
    <sec:authorize access="isAuthenticated()">

        <form:form method="get" action="/ticketapp">
            <input type="submit" value="Aplikacja Ticketowa">
        </form:form>

        <form:form method="get" action="/app/getdeals">
            <input type="submit" value="Obecna Prowizja">
        </form:form>

        <form:form method="get" action="/app/useradd">
            <input type="submit" value="Dodaj Sprzedaż">
        </form:form>

        <form:form method="post" action="/logout">
            <input type="submit" value="Wyloguj"></form:form>
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
