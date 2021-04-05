package com.example.lab4_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/facultyList.jsp")
public class FacultyListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String universityId = request.getParameter("universityId");
        int intUniversityId = Integer.parseInt(universityId);
        request.setAttribute("faculties", UniversitiesData.getInstance().getUniversityById(intUniversityId).getFaculties());
        request.setAttribute("error",request.getParameter("error"));
        getServletContext().getRequestDispatcher("/faculty_list.jsp?universityId="+universityId).forward(request, response);
    }
}
