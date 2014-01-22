package org.market.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMysql {
	
	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String username = "root";
	private final static String password = "Deskmate2314";
	
	public static Connection connect(){
		Connection conn = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Load Driver Successfully");
		String url = "jdbc:mysql://localhost:3306/market_project";
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connect to DataBase Successfully");
		return conn;
	}
}
