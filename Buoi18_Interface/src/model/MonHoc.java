package model;

public class MonHoc {
	private String maMon;
	private String tenMonHoc;
	private int soChi;
	public MonHoc(String maMon, String tenMonHoc, int soChi) {
		super();
		this.maMon = maMon;
		this.tenMonHoc = tenMonHoc;
		this.soChi = soChi;
	}
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	public int getSoChi() {
		return soChi;
	}
	public void setSoChi(int soChi) {
		this.soChi = soChi;
	}
	
	
}
