package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection dbConnection = null;
	
	public static Connection getConnection() {
		
		try {
			// Step 1: Register driver
			registerDriver();

			// Step 2: Open connection
			openConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbConnection;
	}
	
	private static void registerDriver() throws Exception{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	}
	
	private static void openConnection() throws Exception{
		String url = "jdbc:mysql://localhost:3306/quanlysach";
		String user = "root";
		String password = "root";
		dbConnection = DriverManager.getConnection(url, user, password);
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
