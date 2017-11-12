package java_06_luuhoangtrung;

import java.util.Scanner;


public class Lop {
	private String tenLop;
	private String tenKhoa;

	public Lop() {
	}

	public Lop(String tenLop, String tenKhoa) {
		this.tenLop = tenLop;
		this.tenKhoa = tenKhoa;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getTenKhoa() {
		return tenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}

	public void nhapLop(Scanner input){
		System.out.println("Nhập lớp: ");
		this.setTenLop(input.nextLine());
		System.out.println("Nhập khoa: ");
		this.setTenKhoa(input.nextLine());
	}
}
