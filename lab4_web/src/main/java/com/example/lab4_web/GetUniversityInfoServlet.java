package com.example.lab4_web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetUniversityInfoServlet", value = "/GetUniversityInfoServlet")
public class GetUniversityInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("addStatus","OK");

            String universityName = request.getParameter("university");

            University university = new University(universityName);

            request.setAttribute("results", UniversitiesData.getInstance().getInfo(university));


        } catch(IllegalArgumentException e){
            request.setAttribute("addStatus", "invalid parameter");

        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("setuniversityinfo.jsp");
            rd.forward(request, response);
        }
    }

}
