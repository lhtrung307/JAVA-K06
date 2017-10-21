package model;

public class LopHoc {
	private String maLop;
	private String tenLop;
	private int khoa;
	public LopHoc(String maLop, String tenLop, int khoa) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.khoa = khoa;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public int getKhoa() {
		return khoa;
	}
	public void setKhoa(int khoa) {
		this.khoa = khoa;
	}
	
	
}
