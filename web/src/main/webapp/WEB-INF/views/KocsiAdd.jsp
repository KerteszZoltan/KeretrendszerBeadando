<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;encoding=UTF-8 charset=UTF-8" language="java"  %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Kocsi hozzáadása</title>
</head>
<body>


<form:form method="post" action="addKocsi" modelAttribute="kocsi">
    <form:label path="tipus">Tipus</form:label>
    <form:input path="tipus"/>
    <form:label path="keszult">Készítési dátum</form:label>
    <form:input type="date" path="keszult"/>
    <form:label path="telephe">Telephely</form:label>
    <form:input path="telephe"/>
    <form:label path="keszultdb">Hány darab készült</form:label>
    <form:input path="keszultdb"/>
    <form:label path="kategoria">Kategória</form:label>
    <form:select path="kategoria">
        <form:options items="${Rate}"/>
    </form:select>
    <input type="submit" value="Küldés">
</form:form>
</body>
</html>
