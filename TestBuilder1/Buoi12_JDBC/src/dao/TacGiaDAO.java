package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.TacGia;

public class TacGiaDAO {
	private static Connection dbConnection;
	private static Statement dbStatement;
	private static ResultSet setDataFromDB;
	
	public static ArrayList<TacGia> getAllTacGia() {
		ArrayList<TacGia> ketQua = new ArrayList<>();
		try {
			//Step 1: Open connection
//			Connection c = createConnection();
			
			//Step 2: Create statement
			Statement st = c.createStatement();
			String query = "select * from tbl_tacgia";
			
			//Step 3: Excute query
			ResultSet rs = st.executeQuery(query);
			
			//Step 4: Duyet du lieu
			while(rs.next()){
				String maTacGia = getMaTacGiaFromDB();
				String tenTacGia = rs.getString("tenTacGia");
				TacGia tg = new TacGia(maTacGia, tenTacGia);
				ketQua.add(tg);
			}
			DBConnection.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public static String getMaTacGiaFromDB() throws SQLException{
		return setDataFromDB.getString("maTacGia");
	}
	
	public static TacGia selectByMa(String ma) {
		TacGia ketQua = null;
		try {
			//Step 1: Open connection
			Connection dbConnection = createConnection();
			
			//Step 2: Create statement
			Statement st = dbConnection.createStatement();
			String query = "select * from tbl_tacgia where maTacGia = '" + ma + "'";
			
			//Step 3: Excute query
			ResultSet tableTacGia = st.executeQuery(query);
			
			//Step 4: Duyet du lieu
			while(tableTacGia.next()){
				String maTacGia = tableTacGia.getString("maTacGia");
				String tenTacGia = tableTacGia.getString("tenTacGia");
				ketQua = new TacGia(maTacGia, tenTacGia);
			}
			DBConnection.closeConnection(dbConnection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public static Connection createConnection(){
		return DBConnection.getConnection();
	}
	
	public static boolean insert(TacGia tacGia) {
		int soDongThayDoi = 0;
		try {
			//Step 1: Open connection
			Connection c = createConnection();
			
			//Step 2: Create statement
			Statement st = c.createStatement();
			String query = "insert into tbl_tacgia(maTacGia, tenTacGia) value('" + tacGia.getMaTacGia() + "','" + tacGia.getTenTacGia() + "')";
			
			//Step 3: Excute query
			soDongThayDoi = st.executeUpdate(query);
			DBConnection.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soDongThayDoi > 0;
	}
	
	public static boolean delete(TacGia tacGia) {
		int soDongThayDoi = 0;
		try {
			//Step 1: Open connection
			Connection c = createConnection();
			
			//Step 2: Create statement
			Statement st = c.createStatement();
			String query = "delete from tbl_tacgia where maTacGia = '" + tacGia.getMaTacGia() + "'";
			
			//Step 3: Excute query
			soDongThayDoi = st.executeUpdate(query);
			DBConnection.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soDongThayDoi > 0;
	}
	
	public static boolean update(TacGia tacGia) {
		int soDongThayDoi = 0;
		try {
			//Step 1: Open connection
			Connection c = createConnection();
			
			//Step 2: Create statement
			String query = "update tbl_tacgia set tenTacGia = ? where maTacGia = ?";
			PreparedStatement update = c.prepareStatement(query);
			update.setString(1, tacGia.getTenTacGia());
			update.setString(2, tacGia.getMaTacGia());
			//Step 3: Excute query
			soDongThayDoi = update.executeUpdate();
			DBConnection.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soDongThayDoi > 0;
	}
	
	public static void main(String[] args) {
		TacGia tg = new TacGia("TH0001", "Ai lam gi?");
		update(tg);
	}
	
	
}
