package com.sapient.globalinsurancejee.dao;

import com.sapient.globalinsurancejee.controllers.AddPolicyServlet;
import com.sapient.globalinsurancejee.facade.PolicyFacade;
import com.sapient.globalinsurancejee.helpers.PostgresHelper;
import com.sapient.globalinsurancejee.models.Policy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ResourceBundle;

public class PolicyImpl implements PolicyFacade {
    private static final Logger logger = LoggerFactory.getLogger(PolicyImpl.class);
    private ResourceBundle resourceBundle;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private boolean status;
    private String query;

    public PolicyImpl() throws SQLException, ClassNotFoundException {
        System.out.println("Entering constructor......");
        this.resourceBundle = ResourceBundle.getBundle("db");
        this.connection= PostgresHelper.getConnection();
    }

    @Override
    public boolean addPolicy(Policy policy)  {
        System.out.println("Entering policy......");
        query=resourceBundle.getString("policyInsertQuery");
        logger.info("Policy Details"+policy.getPolicyNo());
        logger.info("Policy Details"+policy.getPolicyName());
        logger.info("Policy Details"+policy.getFromDate());
        logger.info("Policy Details"+policy.getToDate());
        logger.info("Policy Details"+policy.getSumInsured());

        try {
            System.out.println("Entering try block......");
            preparedStatement=connection.prepareStatement(query);
            System.out.println("Query"+query);
            preparedStatement.setLong(1,policy.getPolicyNo());
            preparedStatement.setDate(2,Date.valueOf(policy.getFromDate()));
            preparedStatement.setString(3,policy.getPolicyName());
            preparedStatement.setDate(4,Date.valueOf(policy.getToDate()));
            preparedStatement.setLong(5,policy.getSumInsured());
            int rows=preparedStatement.executeUpdate();
            logger.info("rows",rows);
            if (rows>0)
                status=true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return status;
    }


}
