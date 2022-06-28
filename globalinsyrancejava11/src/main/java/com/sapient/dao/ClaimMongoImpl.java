package com.sapient.dao;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.sapient.facades.ClaimFacade;
import com.sapient.helpers.MongoDBHelper;
import com.sapient.models.Claim;
import com.sapient.models.Vehicle;

import java.io.IOException;

public class ClaimMongoImpl implements ClaimFacade {

    private MongoClient mongoClient;
    private MongoCollection mongoCollection;
    public ClaimMongoImpl() {
       mongoClient= MongoDBHelper.getConnection();
       //creating db
       var database= mongoClient.getDatabase("globalinsurancedb");
       database.createCollection("claims");
       mongoCollection= database.getCollection("claims");
    }

    @Override
    public boolean addClaim(Claim claim, Vehicle vehicle) throws IOException {
        return false;
    }
}
