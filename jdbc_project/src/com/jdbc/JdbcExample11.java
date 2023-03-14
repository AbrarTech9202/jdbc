package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample11 {

	public static void main(String[] args) throws SQLException{
		Connection con = null;
		String url="jdbc:mysql://localhost:3306/company?useSSL=false";
		String username="root";
		String password="abrark4961";
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		String query="create table student4(std_Id int not null,std_Name varchar(50),std_Qualification varchar(50),std_class varchar(50))";
		Statement stmt=con.createStatement();
		stmt.executeUpdate(query);
	    System.out.println("table created in database...");	
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
		finally {
			con.close();
		}

	}

}