package com.sapient.globalinsurancejee.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PolicyServlet", value = "/PolicyServlet")
public class PolicyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.println("<h1>Ready to Rock......</h1>");

    }


}
