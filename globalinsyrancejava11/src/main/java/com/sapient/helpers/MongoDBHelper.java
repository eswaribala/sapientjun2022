package com.sapient.helpers;


import com.mongodb.MongoClient;

import java.util.ResourceBundle;

public class MongoDBHelper {

   private ResourceBundle resourceBundle;
   private String host;
   private String port;

    public MongoClient getConnection()
    {
        resourceBundle=ResourceBundle.getBundle("db");
        host=resourceBundle.getString("host");
        port=resourceBundle.getString("port");
        return new MongoClient(host,Integer.parseInt(port));

    }
}
