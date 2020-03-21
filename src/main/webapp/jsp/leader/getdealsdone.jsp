<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Utarg Tabela | Kalkulator Prowizji</title>
    <link rel="stylesheet" href="<c:url value="/resources/static/css/style.css"/>" type="text/css"/>
    <link rel="script" href="<c:url value="/resources/static/js/moveScroll.js"/>"/>
</head>
<body>
<
<div class="tt">
    <font color=#8b0000>
        ${msg}<br/>
        PROWIZJA ${numerlog}: ${total}<br/><br/></font>

    <sec:authorize access="isAuthenticated()">
<center>
    <form:form method="get" action="/leader/getdatabase">
        <input type="submit" value="Wstecz">
    </form:form><br/>
</center>

    <div id="table-container">
        <table id="maintable">
            <thead>
            <tr>
                <th><font color="#32cd32"> ID Klienta &nbsp</font></th>
                <th><font color="#32cd32"> Różnica Ceny</font></th>
                <th><font color="#32cd32"> Segment</font></th>
                <th><font color="#32cd32"> Lojalizowano</font></th>
                <th><font color="#32cd32"> Oferta Rekomendowana</font></th>
                <th><font color="#32cd32"> Lojalizacja 12<</font></th>
                <th><font color="#32cd32"> Produkt Miesiąca</font></th>
                <th><font color="#32cd32"> Całkowity Utarg</font></th>
                <th><font color="#32cd32"> Opcje/Usuń</font></th>
            </tr></thead>
            <tbody>
            <tr>
                <td></td>
                <td>1/2 to podstawa</td>
                <td>3 +5% 4 i 5 +10%</td>
                <td></td>
                <td>+10%</td>
                <td>+10%</td>
                <td>+5%</td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <c:forEach items="${list}" var="pp">
                <tr>
                    <td><fmt:formatNumber maxFractionDigits='0'><c:out value="${pp.clientId}"/></fmt:formatNumber></td>
                    <td><c:out value="${pp.darpu}"/></td>
                    <td><c:out value="${pp.segment}"/></td>
                    <td><c:out value="${pp.loj}"/></td>
                    <td><c:out value="${pp.recCash}"/></td>
                    <td><c:out value="${pp.lojCash}"/></td>
                    <td><c:out value="${pp.mscCash}"/></td>
                    <td><font color="fuchsia"><c:out value="${pp.utarg}"/></font></td>
                    <td><a href="/app/getdealsdone/edit/${pp.id}"> opcje</a></td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
        <table>
            <tr>
                <td>ID Klienta &nbsp</td>
                <td>Różnica Ceny</td>
                <td>Segment</td>
                <td>Lojalizowano</td>
                <td>Oferta Rekomendowana</td>
                <td>Lojalizacja 12<</td>
                <td>Produkt Miesiaca</td>
                <td>Całkowity Utarg</td>
            </tr>
            <td></td>
            <td>1/2 to podstawa</td>
            <td>3 +5% 4 i 5 +10%</td>
            <td></td>
            <td>+10%</td>
            <td>+10%</td>
            <td>+5%</td>
            <td>---</td>
            </tr>
            <tr>
                <td>--&nbsp</td>
                <td>--&nbsp</td>
                <td>--&nbsp</td>
                <td>--&nbsp</td>
                <td>--&nbsp</td>
                <td>--&nbsp</td>
                <td>--&nbsp</td>
                <td>--&nbsp</td>
            </tr>
            <c:forEach items="${list}" var="pp">
                <tr>
                    <td><c:out value="${pp.clientId}"/></td>
                    <td><c:out value="${pp.darpu}"/></td>
                    <td><c:out value="${pp.segment}"/></td>
                    <td><c:out value="${pp.loj}"/></td>
                    <td><c:out value="${pp.recCash}"/></td>
                    <td><c:out value="${pp.lojCash}"/></td>
                    <td><c:out value="${pp.mscCash}"/></td>
                    <td><font color="fuchsia"><c:out value="${pp.utarg}"/></font></td>
                </tr>
            </c:forEach>
        </table>
        <div id="bottom_anchor"></div>
    </div>

    </sec:authorize>

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