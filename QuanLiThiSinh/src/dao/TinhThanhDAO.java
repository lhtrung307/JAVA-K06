package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.TinhThanh;

public class TinhThanhDAO {
	public static ArrayList<TinhThanh> getAllTinhThanh(){
		ArrayList<TinhThanh> tinhThanh = new ArrayList<>();
		try {
			//Open connection
			Connection dbConnection = DBConnection.getConnection();
			//Create statement
			Statement st = dbConnection.createStatement();
			String query = "select * from tbl_tinhthanh";
			
			//Excute query
			ResultSet setTinhThanh = st.executeQuery(query);
			
			//Add to tinhThanh
			while(setTinhThanh.next()){
				int maTinh = setTinhThanh.getInt("maTinh");
				String tenTinh = setTinhThanh.getString("tenTinh");
				TinhThanh data = new TinhThanh(maTinh, tenTinh);
				tinhThanh.add(data);
			}
			DBConnection.closeConnection(dbConnection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tinhThanh;
	}
	
	public static TinhThanh getTinhThanhByMa(int maTinh){
		TinhThanh tinhThanh = new TinhThanh();
		try {
			//Open connection
			Connection dbConnection = DBConnection.getConnection();
			//Create statement
			Statement st = dbConnection.createStatement();
			String query = "select * from tbl_tinhthanh where maTinh = " + maTinh;
			
			//Excute query
			ResultSet resultTinhThanh = st.executeQuery(query);
			
			//Add to tinhThanh
			while(resultTinhThanh.next()){
				tinhThanh.setMaTinh(resultTinhThanh.getInt("maTinh"));
				tinhThanh.setTenTinh(resultTinhThanh.getString("tenTinh"));
			}
			DBConnection.closeConnection(dbConnection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tinhThanh;
	}
	
	public static boolean insertTinhThanh(TinhThanh newTinhThanh) {
		int soDongThayDoi = 0;
		try {
			//Step 1: Open connection
			Connection c = DBConnection.getConnection();
			
			//Step 2: Create statement
			Statement st = c.createStatement();
			String query = "insert into tbl_tinhthanh(maTinh, tenTinh) value(" + newTinhThanh.getMaTinh() + ",'" + newTinhThanh.getTenTinh() + "')";
			
			//Step 3: Excute query
			soDongThayDoi = st.executeUpdate(query);
			DBConnection.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soDongThayDoi > 0;
	}
	
	public static boolean delete(TinhThanh tinhThanh) {
		int soDongThayDoi = 0;
		try {
			//Step 1: Open connection
			Connection c = DBConnection.getConnection();
			
			//Step 2: Create statement
			Statement st = c.createStatement();
			String query = "delete from tbl_tinhthanh where maTinh = " + tinhThanh.getMaTinh();
			
			//Step 3: Excute query
			soDongThayDoi = st.executeUpdate(query);
			DBConnection.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soDongThayDoi > 0;
	}
	
	public static boolean update(TinhThanh tinhThanh) {
		int soDongThayDoi = 0;
		try {
			//Step 1: Open connection
			Connection dbConnection = DBConnection.getConnection();
			
			//Step 2: Create statement
			String query = "update tbl_tinhthanh set tenTinh = ? where maTinh = ?";
			PreparedStatement update = dbConnection.prepareStatement(query);
			update.setString(1, tinhThanh.getTenTinh());
			update.setInt(2, tinhThanh.getMaTinh());
			//Step 3: Excute query
			soDongThayDoi = update.executeUpdate();
			DBConnection.closeConnection(dbConnection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soDongThayDoi > 0;
	}
}
