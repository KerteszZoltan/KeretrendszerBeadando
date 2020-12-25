<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>

<html>
<head>
    <title>Kocsik</title>
</head>
<body>

<c:url var="action" value="/byKategoria"></c:url>
<form:form method="post" action="${action}" modelAttribute="kocsi">
<tr><td><form:label path="kategoria">Kategoria</form:label>
    <form:select path="kategoria" >
        <form:options items="${Kategoria}"/>
    </form:select></td></tr> </td><td>
    <input type="submit" value="Szűrés">
    </form:form>

    <c:url var="action2" value="/keresKocsiID"></c:url>
    <form:form method="post" action="${action2}" modelAttribute="kocsi">
    <tr><td><form:label path="">Keresendő ID: </form:label>
     <form:input path="id" title=" "/>
    </td></tr> </td><td>
    <input type="submit" value="Keresés">
    </form:form>

    <form action="${pageContext.servletContext.contextPath}/kocsik">
    <input type="submit" value="Teljes Kocsi Lista"/>
    </form>


<c:if test="${!empty kocsik}">
    <table frame="border" rules="all">
        <tr><th>ID</th><th>Tipus</th><th>Készült</th><th>hány darab készült</th><th>Telephely</th><th>Kategória</th></tr>
        <c:forEach items="${kocsik}" var="kocsik">
            <tr><td><a href="${pageContext.servletContext.contextPath}/kocsik/${kocsik.id}">${kocsik.id}</a></td><td>${kocsik.tipus}</td><td>${kocsik.keszult}</td><td>${kocsik.keszultdb}</td><td>${kocsik.telephe}</td><td>${kocsik.kategoria}</td><td><a href="${pageContext.servletContext.contextPath}/removeBd/${kocsik.id}">Törlés</a></td><td><a href="${pageContext.servletContext.contextPath}/modifyBd/${kocsik.id}">Módosítás</a></td></tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty kocsik}">
    <c:out value="Nincs Kocsink"/>
</c:if>

<form action="${pageContext.servletContext.contextPath}/ujKocsi">
    <input type="submit" value="Kocsi hozzáadása">
</form>
</body>
</html>
