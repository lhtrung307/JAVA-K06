package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection dbConnection = null;
	public static Connection getConnection(){
		try {
			//Register Driver
			registerDriver();
			//Open Connection
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
		String db_url = "jdbc:mysql://localhost:3306/quanlithisinh";
		String user = "root";
		String password = "root";
		dbConnection = DriverManager.getConnection(db_url, user, password);
	}
	
	public static void closeConnection(Connection connection){
		try {
			if(connection != null){
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
