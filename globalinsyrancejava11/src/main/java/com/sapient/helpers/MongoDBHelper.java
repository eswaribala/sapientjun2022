package com.sapient.helpers;


import com.mongodb.MongoClient;

import java.util.ResourceBundle;

public class MongoDBHelper {

   private static ResourceBundle resourceBundle;
   private static String host;
   private static String port;

    public static MongoClient getConnection()
    {
        resourceBundle=ResourceBundle.getBundle("db");
        host=resourceBundle.getString("host");
        port=resourceBundle.getString("port");
        return new MongoClient(host,Integer.parseInt(port));

    }
}
