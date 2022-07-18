package com.sapient.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PostgresHelper {

    private static ResourceBundle resourceBundle;
    private static String url;
    private static String userName;
    private static String password;


    public static Connection getConnection() throws SQLException {
        resourceBundle=ResourceBundle.getBundle("db");
        url=resourceBundle.getString("postgresUrl");
        userName=resourceBundle.getString("postgresUserName");
        password=resourceBundle.getString("postgresPassword");
        return DriverManager.getConnection(url,userName,password);
    }
}
