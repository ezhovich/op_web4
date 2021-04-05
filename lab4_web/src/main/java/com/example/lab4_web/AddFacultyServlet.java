package com.example.lab4_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/AddFacultyServlet")
public class AddFacultyServlet extends HttpServlet {

    public static final String EMPTY_NAME_ERROR_MESSAGE = "Faculty name can't be empty.";
    public static final String NON_UNIQUE_NAME_ERROR_MESSAGE = "Faculty already exists";
    public static final String ERROR_PARAMETER_NAME = "error=";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String facultyName = request.getParameter("faculty");
        String universityIdStr = request.getParameter("universityId");
        System.out.println(universityIdStr);
        int universityId = Integer.parseInt(universityIdStr);

        if (facultyName == null || facultyName.isEmpty()) {
            response.sendRedirect("facultyList.jsp?universityId=" + universityIdStr + "&" +
                    ERROR_PARAMETER_NAME +
                    EMPTY_NAME_ERROR_MESSAGE);
        } else if (UniversitiesData.getInstance().hasFaculty(universityId, facultyName)) {
            response.sendRedirect("facultyList.jsp?universityId=" + universityIdStr + "&" +
                    ERROR_PARAMETER_NAME +
                    NON_UNIQUE_NAME_ERROR_MESSAGE);
        } else {
            Faculty faculty = new Faculty(facultyName);
            UniversitiesData.getInstance().addFaculty(universityId, faculty);
            response.sendRedirect("facultyList.jsp?universityId=" + universityIdStr);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
