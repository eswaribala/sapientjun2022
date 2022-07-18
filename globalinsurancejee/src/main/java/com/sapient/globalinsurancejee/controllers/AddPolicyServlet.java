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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        HttpSession session = request.getSession();

        String userName = null;
        String password = null;
        if (!session.isNew()) {
            userName = session.getAttribute("userName").toString();
            password = session.getAttribute("password").toString();
        }

        if ((userName != null) && (password != null)) {
            List<String> values = new ArrayList<String>();
            Enumeration<String> names = request.getParameterNames();
            while (names.hasMoreElements()) {

                values.add(request.getParameter(names.nextElement()));
            }

            for (String value : values) {
                logger.info(value);
            }



            Policy policy = new Policy();
            policy.setPolicyNo(Long.parseLong(values.get(0)));
            policy.setPolicyName(values.get(1));
            policy.setFromDate(LocalDate.parse(values.get(2)));
            policy.setToDate(LocalDate.parse(values.get(3)));
            policy.setSumInsured(Long.parseLong(values.get(4)));




            if (policy.getPolicyNo() < 1000) {
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                request.getRequestDispatcher("ErrorServlet").include(request, response);
                request.getRequestDispatcher("insurance.html").include(request, response);
            } else {

                PolicyFacade policyFacade = null;
                try {
                    policyFacade = new PolicyImpl();
                    policyFacade.addPolicy(policy);

                    request.getRequestDispatcher("SuccessServlet").forward(request, response);

                } catch (SQLException | ClassNotFoundException e) {
                    // System.out.println(e.getMessage());
                }
            }


        }
        else
            request.getRequestDispatcher("index.html").forward(request,response);


    }
}
