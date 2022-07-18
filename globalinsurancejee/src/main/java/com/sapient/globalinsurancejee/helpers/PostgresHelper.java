package com.sapient.globalinsurancejee.helpers;

import com.sapient.globalinsurancejee.models.DbConfiguration;

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

    public PostgresHelper(DbConfiguration dbConfiguration) throws ClassNotFoundException {
        url=dbConfiguration.getUrl();
        userName=dbConfiguration.getUserName();

        password=dbConfiguration.getPassword();
        driverName=dbConfiguration.getDriverClassName();
        Class.forName(driverName);
    }

    public static Connection getConnection() throws ClassNotFoundException,SQLException {


        return DriverManager.getConnection(url,userName,password);
    }
}
