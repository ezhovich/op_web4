<%@ page import="java.util.List" %>
<%@ page import="com.example.lab4_web.UniversitiesData" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.example.lab4_web.University" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Universities</title>
</head>
<body>


<h1><%= "Universities" %>
</h1>
<br/>

<c:if test="${error != null}">
    <p style="color:red"><c:out value="${error}" /></p>
</c:if>

<form action="AddUniversityServlet" method="post">
    University name: <input type="text" name = "university" value="">
    <input type="submit" value="Add university"/>
</form>

<ul>
    <c:forEach var="u" items="${universities}">
        <li>
            <form action="RemoveUniversityInfoServlet" method="post">
                <a href="facultyList.jsp?universityId=${u.getId()}"><c:out value="${u.getName()}" /></a>
                <input type="hidden" name="uniId" value="${u.getId()}">
                <input type="submit" value="remove">
            </form>
        </li>

    </c:forEach>
</ul>



</body>
</html>