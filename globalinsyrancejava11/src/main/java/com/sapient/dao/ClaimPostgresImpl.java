package com.sapient.dao;

import com.sapient.facades.ClaimFacade;
import com.sapient.helpers.PostgresHelper;
import com.sapient.models.Claim;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClaimPostgresImpl implements ClaimFacade {

    private  ResourceBundle resourceBundle;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private boolean status;
    private String query;

    public ClaimPostgresImpl() throws SQLException {
        this.resourceBundle = ResourceBundle.getBundle("db");
        this.connection= PostgresHelper.getConnection();
    }

    @Override
    public boolean addPostgresClaim(Claim claim) throws SQLException {
        query=resourceBundle.getString("claimInsertQuery");
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setLong(1,claim.getClaimId());
        preparedStatement.setLong(2,claim.getClaimAmount());
        preparedStatement.setLong(3,claim.getPolicyNo());
        preparedStatement.setDate(4,Date.valueOf(claim.getClaimDate()));
        int rows=preparedStatement.executeUpdate();
        if (rows>0)
            status=true;
        return status;
    }

    @Override
    public boolean updatePostgresClaim(long claimId, long claimAmount) throws SQLException {
        query=resourceBundle.getString("updateClaimAmountQuery");
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setLong(2,claimId);
        preparedStatement.setLong(1,claimAmount);
        int rows=preparedStatement.executeUpdate();
        if (rows>0)
            status=true;
        return status;
    }

    @Override
    public List<Claim> getAllPostgresClaims() throws SQLException {
        query=resourceBundle.getString("selectAllClaims");
        statement=connection.createStatement();
        resultSet=statement.executeQuery(query);
        Claim claim=null;
        List<Claim> claims=new ArrayList<>();
        while(resultSet.next()){
           claim=new Claim();
           claim.setClaimId( resultSet.getLong(1));
           claim.setClaimAmount(resultSet.getLong(2));
           claim.setPolicyNo(resultSet.getLong(3));
           claim.setClaimDate(LocalDate.parse(resultSet.getDate(4).toString()));
           claims.add(claim);
        }
      return claims;
    }

    @Override
    public boolean deleteClaimById(long claimId) {
        return ClaimFacade.super.deleteClaimById(claimId);
    }

    @Override
    public Object getClaimById(long claimId) {
        return ClaimFacade.super.getClaimById(claimId);
    }
}
