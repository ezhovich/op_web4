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



<h1><%= "Students" %>
</h1>
<br/>

<a href="facultyList.jsp?universityId=${param.universityId}">back</a>

<c:if test="${error != null}">
    <p style="color:red"><c:out value="${error}" /></p>
</c:if>

<form action="AddStudentServlet" method="post">
    Student name: <input type="text" name = "student" value="">
    <input type="submit" value="Add student"/>
    <input type="hidden" name="universityId" value="${param.universityId}">
    <input type="hidden" name="facultyId" value="${param.facultyId}">
</form>

<ul>
    <c:forEach var="s" items="${students}">
        <li>
            <form action="RemoveStudentInfoServlet" method="post">
                <a><c:out value="${s.getName()}" /></a>
                <input type="hidden" name="studentId" value="${s.getId()}">
                <input type="hidden" name="facId" value="${param.facultyId}">
                <input type="hidden" name="universityId" value="${param.universityId}">
                <input type="submit" value="remove">
            </form>
        </li>

    </c:forEach>
</ul>



</body>
</html>