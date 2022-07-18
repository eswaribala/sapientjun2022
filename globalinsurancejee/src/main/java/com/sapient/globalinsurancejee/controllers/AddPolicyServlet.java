package com.sapient.globalinsurancejee.controllers;

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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "AddPolicyServlet", value = "/AddPolicyServlet", initParams = {@WebInitParam(name = "driverName",
        value = "org.postgresql.Driver")})
public class AddPolicyServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(AddPolicyServlet.class);
    private boolean status;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        String driverName=getServletConfig().getInitParameter("driverName");
        out.println("<h1>Data Received......</h1>");
        out.println("<h4>We used the driver as"+driverName+"</h4>");


        List<String> values=new ArrayList<String>();
        Enumeration<String> names=request.getParameterNames();
        while(names.hasMoreElements()){

            values.add(request.getParameter(names.nextElement()));
        }

         for(String value:values){
             logger.info(value);
         }

         Policy policy=new Policy();
         policy.setPolicyNo(Long.parseLong(values.get(0)));
         policy.setPolicyName(values.get(1));
         policy.setFromDate(LocalDate.parse(values.get(2)));
         policy.setToDate(LocalDate.parse(values.get(3)));
         policy.setSumInsured(Long.parseLong(values.get(4)));


        PolicyFacade policyFacade= null;
        try {
            policyFacade = new PolicyImpl();
            policyFacade.addPolicy(policy);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }



    }
}
