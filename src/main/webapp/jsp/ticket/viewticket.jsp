<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Edytuj Dane | Kalkulator Prowizji</title>
    <link rel="stylesheet" href="<c:url value="/resources/static/css/style.css"/>" type="text/css"/>
</head>
<body>

<div>
<sec:authorize access="isAuthenticated()">
    <div class="relation">
        <form:form method="post" action="/ticketapp/addStatus" modelAttribute="ticket" name="frm" id="frm">
            Ticket ID: ${oldTicket.id}
            ClientI ID: ${oldTicket.clientId}<br/>
            <form:textarea path="statusUpdate" rows="4" cols="99"/><br/>
            <input type="checkbox" name="closed" id="closed" value="${oldTicket.closed}"/>
            <select name="currentGroup" class="ticketMessage" value="${oldTicket.currentGroup}">
                <option value="helpdesk" ${param.currentGroup == 'helpdesk' ? 'selected' : ''}>helpdesk</option>
                <option value="helpdeskplus" ${param.currentGroup == 'helpdeskplus' ? 'selected' : ''}>helpdeskplus
                </option>
                <option value="cbo" ${param.currentGroup == 'cbo' ? 'selected' : ''}>cbo</option>
            </select>
            <table>
                <tr><td>Meta</td> <td>Update</td></tr>
                <c:forEach items="${statuses}" var="status">
                    <tr><td>${status.username}, ${status.date}</td>
                        <td> ${status.statusUpdate}</td></tr>
                    <c:if test=""
                </c:forEach>
            </table>
            <input type="submit" value="Dodaj wpis"/>
        </form:form>
    </div>
</sec:authorize>

    <div class="logout">
        <sec:authorize access="isAuthenticated()">
            <form:form method="get" action="/provisionapp">
            <input type="submit" value="Aplikacja Prowizje">
        </form:form>
            <form:form method="get" action="/ticketapp">
                <input type="submit" value="Aplikacja ticketowa">
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
</div>
</body>
</html>
