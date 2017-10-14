package model;

import java.util.Scanner;

public class ThiSinh {
	private int maThiSinh;
	private String tenThiSinh;
	private int maQueQuan;
	private String ngaySinh;
	private boolean gioiTinh;
	private float diemToan;
	private float diemLy;
	private float diemHoa;

	public ThiSinh(int maThiSinh, String tenThiSinh,int maQueQuan, String ngaySinh, boolean gioiTinh, float diemToan, float diemLy,
			float diemHoa) {
		this.maThiSinh = maThiSinh;
		this.tenThiSinh = tenThiSinh;
		this.maQueQuan = maQueQuan;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;
	}

	public ThiSinh() {
	}

	public int getMaThiSinh() {
		return maThiSinh;
	}

	public void setMaThiSinh(int maThiSinh) {
		this.maThiSinh = maThiSinh;
	}

	public String getTenThiSinh() {
		return tenThiSinh;
	}

	public void setTenThiSinh(String tenThiSinh) {
		this.tenThiSinh = tenThiSinh;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public float getDiemToan() {
		return diemToan;
	}

	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	public float getDiemLy() {
		return diemLy;
	}

	public void setDiemLy(float diemLy) {
		this.diemLy = diemLy;
	}

	public float getDiemHoa() {
		return diemHoa;
	}

	public void setDiemHoa(float diemHoa) {
		this.diemHoa = diemHoa;
	}

	public void nhapSinhVien(Scanner input) {
		System.out.println("Nhap ma sinh vien: ");
		this.setMaThiSinh(Integer.parseInt(input.nextLine()));
		System.out.println("Nhap ho ten sinh vien:");
		this.setTenThiSinh(input.nextLine());
		System.out.println("Nhap ngay sinh: ");
		this.setNgaySinh(input.nextLine());
	}

	@Override
	public String toString() {
		return "ThiSinh [maThiSinh=" + maThiSinh + ", tenThiSinh=" + tenThiSinh + ", maQueQuan=" + maQueQuan
				+ ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diemToan=" + diemToan + ", diemLy=" + diemLy
				+ ", diemHoa=" + diemHoa + "]";
	}
	
	
}
