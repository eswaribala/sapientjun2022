package com.sapient.globalinsurancejee.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddPolicyServlet", value = "/AddPolicyServlet")
public class AddPolicyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.println("<h1>Data Received......</h1>");
    }
}
