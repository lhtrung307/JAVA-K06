package java_06_luuhoangtrung;

import java.util.Scanner;

public class Ngay {
	private int ngay;
	private int thang;
	private int nam;

	public Ngay() {
		
	}
	
	public Ngay(int ngay, int thang, int nam) {
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}

	public int getNgay() {
		return ngay;
	}

	public void setNgay(int ngay) {
		this.ngay = ngay;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}
	
	public void nhapNgay(Scanner input){
		System.out.println("Nhập ngày sinh: ");
		this.setNgay(Integer.parseInt(input.nextLine()));
		System.out.println("Nhập tháng sinh: ");
		this.setThang(Integer.parseInt(input.nextLine()));
		System.out.println("Nhập năm sinh: ");
		this.setNam(Integer.parseInt(input.nextLine()));
	}
	
	public boolean ktNgay(Ngay ngayKhac){
		return (ngayKhac.getNgay() == this.getNgay() && ngayKhac.getThang() == this.getThang() && ngayKhac.getNam() == this.getNam());
	}

	@Override
	public String toString() {
		return String.format("%02d %02d %04d", this.getNgay(), this.getThang(), this.getNam());
	}
}
