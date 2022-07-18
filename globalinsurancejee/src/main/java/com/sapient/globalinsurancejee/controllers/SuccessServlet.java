package com.sapient.globalinsurancejee.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SuccessServlet", value = "/SuccessServlet")
public class SuccessServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        HttpSession session=request.getSession();
        Cookie[] cookies=request.getCookies();
      //  session.invalidate();
        String userName=null;
        String password=null;
        if (!session.isNew()) {
            userName = session.getAttribute("userName").toString();
            password = session.getAttribute("password").toString();
        }

        if ((userName != null) && (password != null)) {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            String driverName = getServletConfig().getInitParameter("driverName");
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("UserName")){
                    out.println("<h4>"+cookie.getValue().toString()+"</h4>");
                }
            }
            out.println("<h1>Data Added Successfully......</h1>");
            out.println("<h4>We used the driver as" + driverName + "</h4>");
        }
        else{
            request.getRequestDispatcher("index.html").forward(request,response);
        }

    }
}
