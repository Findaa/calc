<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Dodaj Ticket</title>
    <link rel="stylesheet" href="<c:url value="/resources/static/css/style.css"/>" type="text/css"/>
</head>
<body>


<div class="relation">
    <p>
        <textarea name="statusUpdate" form="frm" rows="4" cols="99" required></textarea>
        <br/>

    <form:form method="post" action="/ticket/add" modelAttribute="ticket" id="frm" name="frm">
        Id Klienta
        <input type="text" name="clientid" placeholder="ID Klienta" required/><br/>
        Przypisana Grupa:
        <select name="currentgroup" class="ticketMessage">
            <option value="helpdesk" ${param.currentgroup == 'helpdesk' ? 'selected' : ''}>helpdesk</option>
            <option value="helpdeskplus" ${param.currentgroup == 'helpdeskplus' ? 'selected' : ''}>helpdeskplus</option>
            <option value="cbo" ${param.currentgroup == 'cbo' ? 'selected' : ''}>cbo</option>
        </select>
        <input type="checkbox" name="closed" id="closed"/>
        <input type="submit" value="Dodaj nowy ticket"/>
    </form:form>
    </p>
</div>


<div class="logout">
    <sec:authorize access="isAuthenticated()">

        <form:form method="get" action="/targetadd">
            <input type="submit" value="Prowizja Miesięczna / Target">
        </form:form>

        <form:form method="get" action="/app/getdeals">
            <input type="submit" value="Obecna Prowizja - Wymaga Zalogowani">
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