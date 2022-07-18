package com.sapient.globalinsurancejee.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowLoginServlet", value = "/ShowLoginServlet")
public class ShowLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><title>Login </title></head>");
        String login="";
        String password="";
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for(int i=0; i<cookies.length; i++){
                String test=cookies[i].getName();
                if(test.equals("login")) login=cookies[i].getValue();
                if(test.equals("password"))password=cookies[i].getValue();
            }}
        out.println("<body><form action='LoginServlet' method='post'>");
        out.println("login: <input type='text' name='userName' value='"+ login+"'><br>");
        out.println("password: <input type='text' name='password' value='"+ password+"'><br>");
        out.println("<input type='submit'><br>");
        out.println("</form></body></html>");
    }

}



