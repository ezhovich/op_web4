package com.example.lab4_web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Set;

@WebServlet("/AddUniversityServlet")
public class AddUniversityServlet extends HttpServlet {

    public static final String EMPTY_NAME_ERROR_MESSAGE = "University name can't be empty.";
    public static final String NON_UNIQUE_NAME_ERROR_MESSAGE = "University already exists";
    public static final String ERROR_PARAMETER_NAME = "error=";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String universityName = request.getParameter("university");
        //TODO: add validation(empty string, unique)

        if (universityName == null || universityName.isEmpty()) {
            response.sendRedirect("index.jsp?" +
                    ERROR_PARAMETER_NAME +
                    EMPTY_NAME_ERROR_MESSAGE);
        } else if (UniversitiesData.getInstance().hasUniversity(universityName)) {
            response.sendRedirect("index.jsp?" +
                    ERROR_PARAMETER_NAME +
                    NON_UNIQUE_NAME_ERROR_MESSAGE);
        } else {
            University university = new University(universityName);
            UniversitiesData.getInstance().addUniversity(university);
            response.sendRedirect("index.jsp");
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
