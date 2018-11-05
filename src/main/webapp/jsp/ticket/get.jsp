<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/css; charset=UTF-8"/>
    <title>Strona Główna | Kalkulator Prowizji</title>
    <link rel="stylesheet" href="<c:url value="/resources/static/css/style.css"/>" type="text/css"/>
</head>
<body>

<div class="tt">
<sec:authorize access="isAuthenticated()">
<div id="table-container">
    <table id="ticketlist">
        <thead>
        <tr>
            <th><font color="#32cd32"> ID&nbsp</font></th>
            <th><font color="#32cd32"> ClientID&nbsp</font></th>
            <th><font color="#32cd32"> Closed</font></th>
            <th><font color="#32cd32"> Current Group</font></th>
            <th><font color="#32cd32"> Last Updated</font></th>
            <th><font color="#32cd32"> created</font></th>
        </tr></thead>
        <tbody>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach items="${ticketlist}" var="pp">
            <tr>
                <td><c:out value="${pp.id}"/></td>
                <td><c:out value="${pp.clientid}"/></td>
                <td><c:out value="${pp.closedString}"/></td>
                <td><c:out value="${pp.currentgroup}"/></td>
                <td><c:out value="${pp.username}"/></td>
                <td><c:out value="${pp.ticketCreator}"/></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    </sec:authorize>
</div>
</div>

<form:form method="post" action="/ticketapp">
    <input type="submit" value="wstecz"></form:form>





<div class="logout">
    <sec:authorize access="isAuthenticated()">
        <form:form method="get" action="/logout">
            <input type="submit" value="Wyloguj"></form:form>
    </sec:authorize>
</div>


</body>
</html>



