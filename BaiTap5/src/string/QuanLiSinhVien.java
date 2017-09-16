package string;

import java.util.Scanner;

public class QuanLiSinhVien {
	private String[] tenSinhVien;
	
	public String[] getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String[] tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public QuanLiSinhVien(){}
	
	public QuanLiSinhVien(String... tenSinhVien){
		this.tenSinhVien = tenSinhVien;
	}
	
	public String getLastName(int index){
		int i = tenSinhVien[index].length();
		while(tenSinhVien[index].charAt(i - 1) != ' ' && i-- > 0);
		return tenSinhVien[index].substring(i);
	}
	
	public void swap(int index1, int index2){
		String temp = tenSinhVien[index1];
		tenSinhVien[index1] = tenSinhVien[index2];
		tenSinhVien[index2] = temp;
	}
	
	public void sapXepTen(){
		for(int i = 0; i < tenSinhVien.length - 1; i++){
			for(int j = i + 1; j < tenSinhVien.length; j++){
				if(this.getLastName(i).compareTo(this.getLastName(j)) > 0){
					this.swap(i, j);
				}
			}
		}
	}
	
	public void timTenTrung(String name){
		boolean flag = false;
		for(int i = 0; i < this.getTenSinhVien().length; i++){
			if(this.getTenSinhVien()[i].indexOf(name) != -1){
				flag = true;
				System.out.println(this.getTenSinhVien()[i]);
			}
		}
		if(!flag){
			System.out.println("Khong tim thay ten!!!");
		}
	}
	
	public static void main(String[] args) {
		QuanLiSinhVien test = new QuanLiSinhVien(new String("Luu Hoang Trung"), new String("Pham Thi Thuy Trang"), new String ("Bui Viet Cuong"));
		test.sapXepTen();
		System.out.println(test.getTenSinhVien()[0]);
		System.out.println(test.getTenSinhVien()[1]);
		System.out.println(test.getTenSinhVien()[2]);
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap ten muon tim kiem: ");
		String name = input.nextLine();
		test.timTenTrung(name);
		
		input.close();
	}

}
