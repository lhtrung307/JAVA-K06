package model;

import java.io.Serializable;

public class SinhVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maSinhVien;
	private String hoTen;
	private boolean gioiTinh;
	private double diemTB;
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public double getDiemTB() {
		return diemTB;
	}
	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}
	
	public SinhVien(String maSinhVien, String hoTen, boolean gioiTinh, double diemTB) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diemTB = diemTB;
	}

	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", diemTB="
				+ diemTB + "]";
	}
	
	
}
