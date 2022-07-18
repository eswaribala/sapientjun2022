package com.sapient.globalinsurancejee.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RefundServlet", value = "/RefundServlet")
public class RefundServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Not Right servlet to respond....");

    }


}
