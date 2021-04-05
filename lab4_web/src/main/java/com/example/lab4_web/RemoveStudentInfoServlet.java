package com.example.lab4_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/RemoveStudentInfoServlet")
public class RemoveStudentInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("facId");
        String universityIdStr = request.getParameter("universityId");
        String studentIdStr = request.getParameter("studentId");
        int uniId = Integer.parseInt(universityIdStr);
        int facId = Integer.parseInt(idStr);
        int stdId = Integer.parseInt(studentIdStr);
        University university = UniversitiesData.getInstance().getUniversityById(uniId);
        Faculty faculty = UniversitiesData.getInstance().getFacultyById(uniId, facId);
        Student student = UniversitiesData.getInstance().getStudentById(uniId, facId, stdId);
        UniversitiesData.getInstance().removeStudent(university, faculty, student);
        response.sendRedirect("studentList.jsp?universityId=" + universityIdStr + "&facultyId=" + idStr);
    }


}
