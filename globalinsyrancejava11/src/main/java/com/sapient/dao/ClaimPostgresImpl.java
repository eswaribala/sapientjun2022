package com.sapient.dao;

import com.sapient.facades.ClaimFacade;
import com.sapient.helpers.PostgresHelper;
import com.sapient.models.Claim;

import java.sql.*;
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
    public boolean updateClaim(long claimId, long claimAmount) {
        return ClaimFacade.super.updateClaim(claimId, claimAmount);
    }

    @Override
    public List<Object> getAllClaims() {
        return ClaimFacade.super.getAllClaims();
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
