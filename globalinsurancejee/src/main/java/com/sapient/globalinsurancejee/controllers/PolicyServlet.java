package com.sapient.globalinsurancejee.controllers;

import com.google.gson.Gson;
import com.sapient.globalinsurancejee.dao.PolicyImpl;
import com.sapient.globalinsurancejee.facade.PolicyFacade;
import com.sapient.globalinsurancejee.models.Policy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PolicyServlet", value = "/PolicyServlet")
public class PolicyServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(PolicyServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("application/json");
        Gson gson=new Gson();
        List<Policy> policies=null;
        try {
            PolicyFacade policyFacade=new PolicyImpl();
            policies=policyFacade.getAllPolicies();
            // java object to JSON
            response.getWriter().write(new Gson().toJson(policies));
        } catch (SQLException e) {
         logger.info(e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.info(e.getMessage());
        }


    }


}
