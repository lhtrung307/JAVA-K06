package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.ThiSinh;
import model.TinhThanh;

public class ThiSinhDAO {
	public static ArrayList<ThiSinh> getAllThiSinh(){
		ArrayList<ThiSinh> thiSinh = new ArrayList<>();
		try {
			//Open connection
			Connection dbConnection = DBConnection.getConnection();
			//Create statement
			Statement st = dbConnection.createStatement();
			String query = "select * from tbl_thisinh";
			
			//Excute query
			ResultSet setThiSinh = st.executeQuery(query);
			
			//Add to ThiSinh
			while(setThiSinh.next()){
				int maThiSinh = setThiSinh.getInt("maThiSinh");
				String tenThiSinh = setThiSinh.getString("tenThiSinh");
				TinhThanh tinhThanh = TinhThanhDAO.getTinhThanhByMa(setThiSinh.getInt("maTinh"));
				String ngaySinh = setThiSinh.getString("ngaySinh");
				boolean gioiTinh = setThiSinh.getInt("gioiTinh") != 0 ? true : false;
				float diemToan = setThiSinh.getFloat("diemToan");
				float diemLy = setThiSinh.getFloat("diemLy");
				float diemHoa = setThiSinh.getFloat("diemHoa");
				ThiSinh data = new ThiSinh(maThiSinh, tenThiSinh, tinhThanh.getMaTinh(), ngaySinh, gioiTinh, diemToan, diemLy, diemHoa);
				thiSinh.add(data);
			}
			DBConnection.closeConnection(dbConnection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return thiSinh;
	}
	
	public static ThiSinh getThiSinhByMa(int maThiSinh){
		ThiSinh thiSinh = new ThiSinh();
		try {
			//Open connection
			Connection dbConnection = DBConnection.getConnection();
			//Create statement
			Statement st = dbConnection.createStatement();
			String query = "select * from tbl_thisinh where maThiSinh = " + maThiSinh;
			
			//Excute query
			ResultSet resultThiSinh = st.executeQuery(query);
			
			//Add to ThiSinh
			while(resultThiSinh.next()){
				thiSinh.setMaThiSinh(resultThiSinh.getInt("maThiSinh"));
				thiSinh.setTenThiSinh(resultThiSinh.getString("tenThiSinh"));
			}
			DBConnection.closeConnection(dbConnection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return thiSinh;
	}
	
	public static boolean insertThiSinh(ThiSinh newThiSinh) {
		int soDongThayDoi = 0;
		try {
			//Step 1: Open connection
			Connection c = DBConnection.getConnection();
			
			//Step 2: Create statement
			Statement st = c.createStatement();
			String query = "insert into tbl_ThiSinh(maThiSinh, tenThiSinh) value(" + newThiSinh.getMaThiSinh() + ",'" + newThiSinh.getTenThiSinh() + "')";
			
			//Step 3: Excute query
			soDongThayDoi = st.executeUpdate(query);
			DBConnection.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soDongThayDoi > 0;
	}
	
	public static boolean delete(ThiSinh ThiSinh) {
		int soDongThayDoi = 0;
		try {
			//Step 1: Open connection
			Connection c = DBConnection.getConnection();
			
			//Step 2: Create statement
			Statement st = c.createStatement();
			String query = "delete from tbl_ThiSinh where maThiSinh = " + ThiSinh.getMaThiSinh();
			
			//Step 3: Excute query
			soDongThayDoi = st.executeUpdate(query);
			DBConnection.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soDongThayDoi > 0;
	}
	
	public static boolean update(ThiSinh ThiSinh) {
		int soDongThayDoi = 0;
		try {
			//Step 1: Open connection
			Connection dbConnection = DBConnection.getConnection();
			
			//Step 2: Create statement
			String query = "update tbl_ThiSinh set tenThiSinh = ? where maThiSinh = ?";
			PreparedStatement update = dbConnection.prepareStatement(query);
			update.setString(1, ThiSinh.getTenThiSinh());
			update.setInt(2, ThiSinh.getMaThiSinh());
			//Step 3: Excute query
			soDongThayDoi = update.executeUpdate();
			DBConnection.closeConnection(dbConnection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soDongThayDoi > 0;
	}
}
