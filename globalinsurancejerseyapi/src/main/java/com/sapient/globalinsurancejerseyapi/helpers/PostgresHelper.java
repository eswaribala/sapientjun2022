package com.sapient.globalinsurancejerseyapi.helpers;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PostgresHelper {

    private static ResourceBundle resourceBundle;
    private static String url;
    private static String userName;
    private static String password;

    private static String driverName;



    public static Connection getConnection() throws ClassNotFoundException,SQLException {

         resourceBundle=ResourceBundle.getBundle("db");
         url=resourceBundle.getString("postgresUrl");
         userName=resourceBundle.getString("postgresUserName");
         password=resourceBundle.getString("postgresPassword");
         driverName=resourceBundle.getString("postgresDriver");
         Class.forName(driverName);
        return DriverManager.getConnection(url,userName,password);
    }
}
