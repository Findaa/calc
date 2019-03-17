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
        <select name="leader" class="ticketMessage">
            <option value="leader1" ${param.currentgroup == 'leader1' ? 'selected' : ''}>leader1</option>
            <option value="leader2" ${param.currentgroup == 'leader2' ? 'selected' : ''}>leader2</option>
            <option value="cbo" ${param.currentgroup == 'cbo' ? 'selected' : ''}>cbo</option>
        </select><br/>
        <%
            String currentgroup = request.getParameter("currentgroup");
        %>

        <input type="submit" value="Zarejestruj"/>
    </form:form><br/>
    <form:form method="get" action="index">
        <input type="submit" value="Strona Główna">
    </form:form><br/>
    Registration is blocked due to proxy server.
<br/>
    ID Leaderow:<br/>
    leader1<br/>
    leader2<br/>
</div>

</body>
</html>
