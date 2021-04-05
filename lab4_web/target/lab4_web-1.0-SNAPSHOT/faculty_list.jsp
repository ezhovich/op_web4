<%@ page import="java.util.List" %>
<%@ page import="com.example.lab4_web.UniversitiesData" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.example.lab4_web.University" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Faculties</title>
</head>
<body>



<h1><%= "Faculties" %>
</h1>
<br/>

<a href="index.jsp">back</a>

<c:if test="${error != null}">
    <p style="color:red"><c:out value="${error}" /></p>
</c:if>

<form action="AddFacultyServlet" method="post">
    Faculty name: <input type="text" name = "faculty" value="">
    <input type="submit" value="Add faculty"/>
    <input type="hidden" name="universityId" value="${param.universityId}">
</form>

<ul>
    <c:forEach var="f" items="${faculties}">
        <li>
            <form action="RemoveFacultyInfoServlet" method="post">
                <a href="studentList.jsp?universityId=${param.universityId}&facultyId=${f.getId()}"><c:out value="${f.getName()}" /></a>
                <input type="hidden" name="facId" value="${f.getId()}">
                <input type="hidden" name="universityId" value="${param.universityId}">
                <input type="submit" value="remove">
            </form>
        </li>

    </c:forEach>
</ul>



</body>
</html>