package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Sach;

public class SachDAO {
	public static ArrayList<Sach> selectAll(){
		ArrayList<Sach> ketqua = new ArrayList<>();
		try {
			Connection connection = DBConnection.getConnection();
			String sql = "select * from tbl_sach";
			PreparedStatement p = connection.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				String maSach = rs.getString("maSach");
				String maTacGia = rs.getString("maTacGia");
				int namXuatBan = rs.getInt("namXuatBan");
				String tenSach = rs.getString("tenSach");
				double giaBan = rs.getDouble("giaBan");
				ketqua.add(new Sach(maSach, tenSach, maTacGia, namXuatBan, giaBan));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ketqua;
	}
	
	public static ArrayList<Sach> selectByMa(String maSach){
		ArrayList<Sach> ketqua = new ArrayList<>();
		try {
			Connection connection = DBConnection.getConnection();
			String sql = "select * from tbl_sach where maSach = ?";
			PreparedStatement p = connection.prepareStatement(sql);
			p.setString(1, maSach);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				String maTacGia = rs.getString("maTacGia");
				int namXuatBan = rs.getInt("namXuatBan");
				String tenSach = rs.getString("tenSach");
				double giaBan = rs.getDouble("giaBan");
				ketqua.add(new Sach(maSach, tenSach, maTacGia, namXuatBan, giaBan));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ketqua;
	}
	
	public static boolean insert(Sach sach) {
		int soDongThayDoi = 0;
		try {
			//Step 1: Open connection
			Connection c = DBConnection.getConnection();
			
			//Step 2: Create statement
			
			String sql = "insert into tbl_sach(maSach, tenSach, maTacGia, namXuatBan, giaBan) value(?,?,?,?,?)";
			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1, sach.getMaSach());
			p.setString(2, sach.getTenSach());
			p.setString(3, sach.getMaTacGia());
			p.setInt(4, sach.getNamXuatBan());
			p.setDouble(5, sach.getGiaBan());
			//Step 3: Excute query
			soDongThayDoi = p.executeUpdate();
			DBConnection.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soDongThayDoi > 0;
	}
	
	public static boolean update(Sach sach) {
		int soDongThayDoi = 0;
		try {
			//Step 1: Open connection
			Connection c = DBConnection.getConnection();
			
			//Step 2: Create statement
			
			String sql = "update tbl_sach set tenSach = ?, maTacGia = ?, namXuatBan = ?, giaBan = ? where maSach = ?";
			PreparedStatement p = c.prepareStatement(sql);
			
			p.setString(1, sach.getTenSach());
			p.setString(2, sach.getMaTacGia());
			p.setInt(3, sach.getNamXuatBan());
			p.setDouble(4, sach.getGiaBan());
			p.setString(5, sach.getMaSach());
			//Step 3: Excute query
			soDongThayDoi = p.executeUpdate();
			DBConnection.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soDongThayDoi > 0;
	}
	
	public static boolean delete(Sach sach) {
		int soDongThayDoi = 0;
		try {
			//Step 1: Open connection
			Connection c = DBConnection.getConnection();
			
			//Step 2: Create statement
			
			String sql = "delete from tbl_sach where maSach = ?";
			PreparedStatement p = c.prepareStatement(sql);
			
			p.setString(1, sach.getMaSach());
			//Step 3: Excute query
			soDongThayDoi = p.executeUpdate();
			DBConnection.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soDongThayDoi > 0;
	}
	
	public static void main(String[] args) {
//		ArrayList<Sach> ketqua;
//		ketqua = selectAll();
//		ketqua = selectByMa("VH001");
//		for (Sach sach : ketqua) {
//			System.out.println(sach);
//		}
		
		Sach sachMoi = new Sach("TH001", "Cau truc du lieu va Giai thuat", "TH0001", 2013, 30000);
//		update(sachMoi);
		delete(sachMoi);
		
		ArrayList<Sach> ketqua;
		ketqua = selectAll();
		for (Sach sach : ketqua) {
			System.out.println(sach);
		}
	}
}
