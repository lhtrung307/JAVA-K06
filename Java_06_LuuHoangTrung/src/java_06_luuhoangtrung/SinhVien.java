package java_06_luuhoangtrung;

import java.util.Scanner;

public class SinhVien {
	private String MSSV;
	private String ho;
	private String ten;
	private Ngay ngaySinh;
	private double diemTB;
	private Lop lop;
	
	public SinhVien() {
		ngaySinh = new Ngay();
		lop = new Lop();
	}

	public SinhVien(String mSSV, String ho, String ten, Ngay ngaySinh, double diemTB, Lop lop) {
		super();
		MSSV = mSSV;
		this.ho = ho;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.diemTB = diemTB;
		this.lop = lop;
	}

	public String getMSSV() {
		return MSSV;
	}

	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Ngay getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Ngay ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}
	
	public String getTenKhoa(){
		return this.getLop().getTenKhoa();
	}
	
	public boolean ktDau(){
		return getDiemTB() >= 5;
	}
	
	public boolean ktNgaySinh(SinhVien svKhac){
		return svKhac.getNgaySinh().ktNgay(this.getNgaySinh());
	}
	
	public void nhapSV(Scanner input){
		System.out.println("Nhập mã số sinh viên: ");
		this.setMSSV(input.nextLine());
		System.out.println("Nhập họ sinh viên: ");
		this.setHo(input.nextLine());
		System.out.println("Nhập tên sinh viên: ");
		this.setTen(input.nextLine());
		System.out.println("Nhập ngày tháng năm sinh: ");
		this.getNgaySinh().nhapNgay(input);
		System.out.println("Nhập điểm trung bình: ");
		this.setDiemTB(Double.parseDouble(input.nextLine()));
		System.out.println("Nhập lớp: ");
		this.getLop().nhapLop(input);
		
	}
	
	@Override
	public String toString() {
		return String.format("Thông tin sinh viên: \n"
				+ "%s\n%s %s\n%s\n%.02f\n%s\n%s", getMSSV(), getHo(), getTen(), getNgaySinh().toString(), getDiemTB(), getLop().getTenLop(), getTenKhoa());
	}
}
