package com.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

public class JdbcCaradOperation {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String url = "jdbc:mysql://localhost:3306/student?useSSL=false";
	static String username = "root";
	static String password = "abrark4961";
	static String driver = "com.mysql.cj.jdbc.Driver";
	static PreparedStatement pstmt = null;
	static Connection con = null;
	static String delete ="delete from college where";
	static String id="Clg_ID";
	static String name="Clg_NAME";
	static String address="Clg_ADDRESS";

	public static void insertRecods() throws SQLException, IOException, ClassNotFoundException {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			String q = "Insert into college(Clg_NAME,Clg_ADDRESS) values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);
			System.out.println("Enter "+name);
			String Clg_NAME = br.readLine();
			System.out.println("Enter "+address);
			String Clg_ADDRESS = br.readLine();
			pstmt.setString(1, Clg_NAME);
			pstmt.setString(2, Clg_ADDRESS);
			pstmt.executeUpdate();
		} finally {
			con.close();
		}
	}

	public static void updatesRecods() throws ClassNotFoundException, SQLException, IOException {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			String q = "update college set  Clg_NAME=? where Clg_Id=?";

			PreparedStatement pstmt = con.prepareStatement(q);
			System.out.println("entre college name");
			String Clg_NAME = br.readLine();
			System.out.println("entre Clg_Id nomber");
			String Clg_Id = br.readLine();
			pstmt.setString(1, Clg_NAME);
			pstmt.setString(2, Clg_Id);
			pstmt.executeUpdate();
		} finally {
			con.close();
		}
	}

	public static void deleteRecods() throws SQLException, ClassNotFoundException, IOException {
		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, username, password);
			System.out.println("entre Clg_ID/Clg_NAME/Clg_ADDRESS...");
			String choose = br.readLine();

			if (choose.equalsIgnoreCase("Clg_ID")) {
				String q = "Clg_ID=?";
				pstmt = con.prepareStatement(delete+q);
				System.out.println("Enter College Id");
				String Clg_ID = br.readLine();
				pstmt.setString(1, Clg_ID);
				System.out.println("Successfully Deleted " + choose + " " + Clg_ID);
			} else if (choose.equalsIgnoreCase("Clg_NAME")) {
				String q2 = "Clg_NAME=?";
				pstmt = con.prepareStatement(delete+q2);
				System.out.println("Enter Clg_NAME");
				String Clg_NAME = br.readLine();
				pstmt.setString(1, Clg_NAME);
				System.out.println("Successfully Deleted " + choose + " " + Clg_NAME);
			} else if (choose.equalsIgnoreCase("Clg_ADDRESS")) {
				String q3 = "Clg_ADDRESS=?";
				pstmt = con.prepareStatement(delete+q3);
				System.out.println("Enter Clg_ADDRESS");
				String Clg_ADDRESS = br.readLine();
				pstmt.setString(1, Clg_ADDRESS);
				System.out.println("Successfully Deleted " + choose + " " + Clg_ADDRESS);
			}

			pstmt.executeUpdate();

		} finally {
			con.close();
		}
	}

	public static void getFetchRecods() throws SQLException, ClassNotFoundException {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			String q = "select * from college";
			con.prepareStatement(q);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(
						rs.getString("Clg_ID") + " " + rs.getString("Clg_NAME") + " " + rs.getString("Clg_ADDRESS"));
			}
		}

		finally {
			con.close();
		}
	}

	public static void autorun() throws IOException, ClassNotFoundException, SQLException {
		System.out.println("choose program option?(insert/update/delete/Fetch)");
		String choosoption = br.readLine();
		switch (choosoption) {
		case "insert":
			JdbcCaradOperation.insertRecods();
			break;
		case "update":
			JdbcCaradOperation.updatesRecods();
			break;
		case "delete":
			JdbcCaradOperation.deleteRecods();
			break;
		case "fetch":
			JdbcCaradOperation.getFetchRecods();
			break;
		default:
			System.out.println("you have not any opreatin in this program");
		}
		System.out.println("choose option? (yes/no)");
		String str = br.readLine();
		if (str.equalsIgnoreCase("yes") | str.equalsIgnoreCase("y")) {
			JdbcCaradOperation.autorun();
		} else if (str.equalsIgnoreCase("no") | str.equalsIgnoreCase("n")) {
			System.out.println("thnks.....");
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

		JdbcCaradOperation.autorun();
	}
}