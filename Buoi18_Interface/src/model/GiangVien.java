package model;

public class GiangVien {
	private String maGiangVien;
	private String tenGiangVien;

	public GiangVien(String maGiangVien, String tenGiangVien) {
		this.maGiangVien = maGiangVien;
		this.tenGiangVien = tenGiangVien;
	}

	public String getMaGiangVien() {
		return maGiangVien;
	}

	public void setMaGiangVien(String maGiangVien) {
		this.maGiangVien = maGiangVien;
	}

	public String getTenGiangVien() {
		return tenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}

}
