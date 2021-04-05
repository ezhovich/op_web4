package com.example.lab4_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentList.jsp")
public class StudentListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String universityId = request.getParameter("universityId");
        String facultyId = request.getParameter("facultyId");
        int intFacultyId = Integer.parseInt(facultyId);
        int intUniversityId = Integer.parseInt(universityId);
        request.setAttribute("students", UniversitiesData.getInstance().getFacultyById(intUniversityId, intFacultyId).getStudents());
        request.setAttribute("error",request.getParameter("error"));
        getServletContext().getRequestDispatcher("/student_list.jsp?universityId="+universityId + "&" + "facultyId="+facultyId).forward(request, response);
    }
}
