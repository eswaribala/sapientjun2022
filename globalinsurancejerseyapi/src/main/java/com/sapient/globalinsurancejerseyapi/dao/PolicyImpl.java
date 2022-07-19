package com.sapient.globalinsurancejerseyapi.dao;

import com.sapient.globalinsurancejerseyapi.facades.PolicyFacade;
import com.sapient.globalinsurancejerseyapi.helpers.PostgresHelper;
import com.sapient.globalinsurancejerseyapi.models.Policy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

        this.resourceBundle = ResourceBundle.getBundle("db");
        this.connection= PostgresHelper.getConnection();
    }

    @Override
    public boolean addPolicy(Policy policy) throws SQLException {

        query=resourceBundle.getString("policyInsertQuery");
        logger.info("Policy Details"+policy.getPolicyNo());
        logger.info("Policy Details"+policy.getPolicyName());
        logger.info("Policy Details"+policy.getFromDate());
        logger.info("Policy Details"+policy.getToDate());
        logger.info("Policy Details"+policy.getSumInsured());



            preparedStatement=connection.prepareStatement(query);

            preparedStatement.setLong(1,policy.getPolicyNo());
            preparedStatement.setDate(2,Date.valueOf(policy.getFromDate()));
            preparedStatement.setString(3,policy.getPolicyName());
            preparedStatement.setDate(4,Date.valueOf(policy.getToDate()));
            preparedStatement.setLong(5,policy.getSumInsured());
            int rows=preparedStatement.executeUpdate();
            logger.info("rows",rows);
            if (rows>0)
                status=true;


        return status;
    }

    @Override
    public List<Policy> getAllPolicies() throws SQLException {
        query=resourceBundle.getString("selectAllPolicies");
        statement=connection.createStatement();
        resultSet=statement.executeQuery(query);
        Policy policy=null;
        List<Policy> policies=new ArrayList<>();
        while(resultSet.next()){
            policy=new Policy();
            policy.setPolicyNo( resultSet.getLong(1));
            policy.setFromDate(LocalDate.parse(resultSet.getDate(2).toString()));
            policy.setPolicyName(resultSet.getString(3));
            policy.setToDate(LocalDate.parse(resultSet.getDate(4).toString()));
            policy.setSumInsured(resultSet.getLong(5));
            policies.add(policy);
        }
        return policies;
    }


}
