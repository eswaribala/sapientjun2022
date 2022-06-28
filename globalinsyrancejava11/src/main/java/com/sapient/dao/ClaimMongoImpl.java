package com.sapient.dao;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.sapient.facades.ClaimFacade;
import com.sapient.helpers.MongoDBHelper;
import com.sapient.models.Claim;
import com.sapient.models.Vehicle;

import java.io.IOException;
import java.util.ResourceBundle;

public class ClaimMongoImpl implements ClaimFacade {

    private MongoClient mongoClient;
    private MongoCollection mongoCollection;
    private ResourceBundle resourceBundle;
    private boolean status;
    public ClaimMongoImpl() {
        resourceBundle=ResourceBundle.getBundle("db");
       mongoClient= MongoDBHelper.getConnection();
       //creating db
       var database= mongoClient
               .getDatabase(resourceBundle.getString("dbname"));
       var collectionName=resourceBundle.getString("collectionName");
       database.createCollection(collectionName);
       mongoCollection= database.getCollection(collectionName);
    }

    @Override
    public boolean addClaim(Claim claim){
        mongoCollection.insertOne(claim);
        status=true;
        return status;
    }
}
