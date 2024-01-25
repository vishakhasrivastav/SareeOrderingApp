package com.saree.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection makeConnection() {
		Connection con=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

            String user = "root";
            String password = "Vishu@2003";
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SareeProject_6370", user, password);

	}
	catch(Exception e) {
		e.printStackTrace();
		}
		
		return con;
	}
public static void main(String[] args) {
		
		Connection con=makeConnection();
		if(con!=null)
			System.out.println("Connection made successfully");
		else
			System.out.println("Error");	
}
}
