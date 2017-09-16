package hocthem;

import java.util.Scanner;

public class Sach {
	private String ten;
	private double giaBan;
	private int namPhatHanh;
	private int soTrang;
	private TacGia tacGia;
	
	public Sach(String ten, double giaBan, int namPhatHanh, int soTrang, TacGia tacGia) {
		this.ten = ten;
		this.giaBan = giaBan;
		this.namPhatHanh = namPhatHanh;
		this.soTrang = soTrang;
		this.tacGia = tacGia;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getNamPhatHanh() {
		return namPhatHanh;
	}

	public void setNamPhatHanh(int namPhatHanh) {
		this.namPhatHanh = namPhatHanh;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public TacGia getTacGia() {
		return tacGia;
	}

	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}
	
	public static void main(String[] args) {
//		Ngay ngay = new Ngay(20, 10 ,2017);
//		TacGia tacGia = new TacGia("asdfasd", ngay);
//		Sach sach = new Sach("sadfasdf", 100000, 2017, 300, tacGia);
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ngay: ");
		int ngay = sc.nextInt();
		System.out.println("Nhap thang: ");
		int thang = sc.nextInt();
		System.out.println("Nhap nam: ");
		int nam = sc.nextInt();
		Ngay ngaySinh = new Ngay(ngay, thang, nam);
		System.out.println(ngaySinh.getNgay());
		System.out.println(ngaySinh.getThang());
		System.out.println(ngaySinh.getNam());
		sc.close();
	}
}
