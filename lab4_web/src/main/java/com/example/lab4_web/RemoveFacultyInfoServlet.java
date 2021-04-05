package com.example.lab4_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/RemoveFacultyInfoServlet")
public class RemoveFacultyInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("facId");
        String universityIdStr = request.getParameter("universityId");
        int uniId = Integer.parseInt(universityIdStr);
        int facId = Integer.parseInt(idStr);
        University university = UniversitiesData.getInstance().getUniversityById(uniId);
        Faculty faculty = UniversitiesData.getInstance().getFacultyById(uniId, facId);
        UniversitiesData.getInstance().removeFaculty(university, faculty);
        response.sendRedirect("facultyList.jsp?universityId="+universityIdStr);
    }


}
