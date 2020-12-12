<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;encoding=UTF-8 charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Módosítás</title>
</head>
<body>
<table>
    <c:url var="action" value="/modify"></c:url>
<form:form method="post" action="${action}" modelAttribute="kocsi">
    <form:input type="hidden" path="id"/>
    <tr><td><form:label path="tipus">Név</form:label></td><td><form:input path="tipus"/></td></tr>
    <tr><td> <form:label path="keszult">Készülési dátum</form:label></td><td> <form:input type="date" path="keszult" /></td></tr>
    <tr><td> <form:label path="telephe">Telephely</form:label></td><td> <form:input path="telephe" /></td></tr>
    <tr><td> <form:label path="keszultdb">Hány darab készült</form:label></td><td><form:input path="keszultdb" /> </td></tr>
    <tr><td><form:label path="kategoria">Kategória</form:label>
        <form:select path="kategoria" >
            <form:options items="${Kategoria1}"/>
        </form:select></td></tr> </td><td>
    <input type="submit" value="Módosítás">
    </form:form>
</table>


</body>
</html>
