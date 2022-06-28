package com.sapient.dao;


import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DocumentToDBRefTransformer;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.sapient.facades.ClaimFacade;
import com.sapient.helpers.MongoDBHelper;
import com.sapient.models.Claim;
import com.sapient.models.Vehicle;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.mongodb.client.model.Filters.eq;

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
        //java object to json
        //json to bson document
        Document document= Document.parse(gson.toJson(claim));
        mongoCollection.insertOne(document);
        status=true;
        return status;
    }

    @Override
    public boolean updateClaim(long claimId, long claimAmount) {
        mongoCollection.updateOne(new Document("claimId",claimId),
               new Document("$set",new Document("claimAmount",claimAmount)));
        status=true;
        return status;
    }

    @Override
    public List<Object> getAllClaims() {
        ArrayList<Object> claims=new ArrayList<>();
       try(MongoCursor<Document> cursor= mongoCollection.find()
               .sort(new Document("claimd",1)).limit(1)
        .iterator()){
           while(cursor.hasNext()){
               var doc=cursor.next();
               claims.add(doc.values());
           }
       }
        return claims;
    }

    //deletion


    @Override
    public boolean deleteClaimById(long claimId) {
        mongoCollection.deleteOne(eq("claimId",claimId));
        status=true;
        return status;
    }

    @Override
    public Object getClaimById(long claimId) {
       return ((Document)mongoCollection.find(eq("claimId", claimId)).first()).values();

    }
}
