<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Dodaj Dane | Kalkulator Prowizji</title>
    <link rel="stylesheet" href="<c:url value="/resources/static/css/style.css"/>" type="text/css"/>
</head>
<body>


<div class="relation">
    <p>
        <form:form method="post" action="/app/useradd" modelAttribute="deal">
    <p id="loginpagelabel">Podaj dane</p>
    <d>NrLogowy IdKlienta DeltaArpu Segment</d>
    <br/>
    <input type="text" name="log" placeholder="Numer Logowy" required/>
    <input type="text" name="clientId" placeholder="ID Klienta" required/>
    <input type="text" name="darpu" placeholder="Różnica Arpu" onchange="this.value = this.value.replace(',', '.')"
           required/>
    <input type="text" name="segment" placeholder="Segment" required/><br/><br/><br/><br/>
    loj &nbsp&nbsp&nbsp&nbsp rek &nbsp&nbsp&nbsp&nbsp 12< &nbsp&nbsp msc&nbsp&nbsp NOWY?<br/>
    <input type="checkbox" name="loj" id="loj"/>&nbsp&nbsp&nbsp
    <input type="checkbox" name="recomended" id="'recomended"/>&nbsp&nbsp&nbsp
    <input type="checkbox" name="okresLoj" id="'okresLoj"/>&nbsp&nbsp&nbsp
    <input type="checkbox" name="msc" id="msc"/>&nbsp&nbsp&nbsp
    <input type="checkbox" name="newClient" id="newClient"/><br/></div>
    <div class="relation">loj -> Czy klient został zlojalizowany? &nbsp &nbsp
    rek -> Czy oferta była rekomendowana? &nbsp &nbsp
    12< -> Czy w wypadku lojalizacji, była większa niż 12msc? &nbsp &nbsp
        msc -> Czy sprzedano produkt miesiąca? &nbsp &nbsp</div>
    <br/><br/>

    <input type="submit" value="Dodaj Sprzedaż"/>
    </form:form>
    </p>
</div>

<div class="logout">
    <sec:authorize access="isAuthenticated()">


        <form:form method="get" action="/ticketapp">
            <input type="submit" value="Aplikacja Ticketowa">
        </form:form>



        <form:form method="get" action="/targetadd">
            <input type="submit" value="Prowizja Miesięczna / Target">
        </form:form>

        <form:form method="get" action="/app/getdeals">
            <input type="submit" value="Obecna Prowizja">
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