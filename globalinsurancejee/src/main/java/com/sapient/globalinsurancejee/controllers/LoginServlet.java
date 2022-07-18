package com.sapient.globalinsurancejee.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        HttpSession session=request.getSession();
        Cookie cookie=new Cookie("UserName",userName);
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        if((userName!=null) && (password!=null)){
            session.setAttribute("userName",userName);
            session.setAttribute("password",password);
            request.getRequestDispatcher("insurance.html").forward(request,response);
        }


    }
}
