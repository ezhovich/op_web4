package com.example.lab4_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

    public static final String EMPTY_NAME_ERROR_MESSAGE = "Student name can't be empty.";
    public static final String NON_UNIQUE_NAME_ERROR_MESSAGE = "Student already exists";
    public static final String ERROR_PARAMETER_NAME = "error=";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String facultyName = request.getParameter("facultyId");
        String universityIdStr = request.getParameter("universityId");
        String studentName = request.getParameter("student");

        int universityId = Integer.parseInt(universityIdStr);
        int facultyId = Integer.parseInt(facultyName);

        if (studentName == null || studentName.isEmpty()) {
            response.sendRedirect("studentList.jsp?universityId=" + universityIdStr + "&" + "facultyId=" + facultyName + "&" +
                    ERROR_PARAMETER_NAME +
                    EMPTY_NAME_ERROR_MESSAGE);
        } else if (UniversitiesData.getInstance().hasStudent(universityId, facultyId, studentName)) {
            response.sendRedirect("studentList.jsp?universityId=" + universityIdStr + "&" + "facultyId=" + facultyName + "&" +
                    ERROR_PARAMETER_NAME +
                    NON_UNIQUE_NAME_ERROR_MESSAGE);
        } else {
            Student student = new Student(studentName);
            UniversitiesData.getInstance().addStudent(universityId, facultyId, student);
            response.sendRedirect("studentList.jsp?universityId=" + universityIdStr + "&facultyId=" + facultyName);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
