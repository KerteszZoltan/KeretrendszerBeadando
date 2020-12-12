<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>${kocsi.tipus}</title>
</head>
<body>
<table>
    <tr><td>ID: </td><td>${kocsi.id}</td></tr>
    <tr><td>Tipus: </td><td>${kocsi.tipus}</td></tr>
    <tr><td>Készítési dátum: </td><td>${kocsi.keszult}</td></tr>
    <tr><td>Kategória:</td><td>${kocsi.kategoria}</td></tr>
    <tr><td>Telephely</td><td>${kocsi.telephe}</td></tr>
    <tr><td>Hány darab készült:</td><td>${kocsi.keszultdb}</td></tr>
</table>
<form action="${pageContext.servletContext.contextPath}/kocsik">
    <input type="submit" value="Vissza a kocsik listához">
</form>
</body>
</html>
