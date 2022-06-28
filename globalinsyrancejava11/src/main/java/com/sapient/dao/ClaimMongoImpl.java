package com.sapient.dao;


import com.google.gson.Gson;
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
    private Gson gson;
    public ClaimMongoImpl() {
        resourceBundle=ResourceBundle.getBundle("db");
       mongoClient= MongoDBHelper.getConnection();
       //creating db
       var database= mongoClient
               .getDatabase(resourceBundle.getString("dbname"));
       var collectionName=resourceBundle.getString("collectionName");
       if(database.getCollection(collectionName)==null)
          database.createCollection(collectionName);
       mongoCollection= database.getCollection(collectionName);
       gson=new Gson();
    }

    @Override
    public boolean addClaim(Claim claim){
        mongoCollection.insertOne(gson.toJson(claim));
        status=true;
        return status;
    }
}
