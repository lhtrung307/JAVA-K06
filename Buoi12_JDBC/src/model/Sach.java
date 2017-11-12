package model;

public class Sach {
	private String maSach;
	private String tenSach;
	private String maTacGia;
	private int namXuatBan;
	private double giaBan;

	public Sach() {
	}

	public Sach(String maSach, String tenSach, String maTacGia, int namXuatBan, double giaBan) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.maTacGia = maTacGia;
		this.namXuatBan = namXuatBan;
		this.giaBan = giaBan;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getMaTacGia() {
		return maTacGia;
	}

	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", maTacGia=" + maTacGia + ", namXuatBan="
				+ namXuatBan + ", giaBan=" + giaBan + "]";
	}

}
