package com.example.lab4_web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/RemoveUniversityInfoServlet")
public class RemoveUniversityInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idStr = request.getParameter("uniId");
        int id = Integer.parseInt(idStr);
        University university = UniversitiesData.getInstance().getUniversityById(id);
        UniversitiesData.getInstance().removeUniversity(university);
        response.sendRedirect("index.jsp");
    }


}
