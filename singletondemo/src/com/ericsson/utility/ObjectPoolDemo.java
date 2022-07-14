package com.ericsson.utility;

import java.sql.Connection;

import com.ericsson.models.JDBCConnectionPool;

public class ObjectPoolDemo {
	  public static void main(String args[]) {
		    // Do something...
		    
		    // Create the ConnectionPool:
		    JDBCConnectionPool pool = new JDBCConnectionPool(
		      "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/opentextdb?useSSL=true",
		      "root", "vignesh");

		    // Get a connection:
		    Connection con = pool.checkOut();

		    // Use the connection
		    
		    // Return the connection:
		    pool.checkIn(con);
		 
		  }
		}