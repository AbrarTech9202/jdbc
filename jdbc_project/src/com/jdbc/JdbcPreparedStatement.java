package com.jdbc;

import java.sql.*;

public class JdbcPreparedStatement {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hostel?useSSL=false";
			String username = "root";
			String password = "abrark4961";
			Connection con = DriverManager.getConnection(url, username, password);
			String q = "insert into abrar(name,age) values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);
//			pstmt.setString(1, "kkk");
			pstmt.setString(1, "Aasim");
			pstmt.setInt(2, 33);
			pstmt.executeUpdate();
			System.out.println("inserted....");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
