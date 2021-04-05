package com.example.lab4_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/index.jsp")
public class UniversityListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("universities", UniversitiesData.getInstance().getUniversities());
        request.setAttribute("error",request.getParameter("error"));
        getServletContext().getRequestDispatcher("/university_list.jsp").forward(request, response);
    }
}
