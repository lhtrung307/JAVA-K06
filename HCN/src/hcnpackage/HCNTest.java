package hcnpackage;

import java.util.Scanner;

public class HCNTest{

	public static void main(String[] args) {
		int n;
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap so luong hinh chu nhat: ");
		n = input.nextInt();
		HinhChuNhat[] hcn = new HinhChuNhat[n];
		double chieuDai, chieuRong;
		for(int i = 0; i < n; i++){
			System.out.println("Nhap chieu dai: ");
			chieuDai = input.nextDouble();
			System.out.println("Nhap chieu rong: ");
			chieuRong = input.nextDouble();
			hcn[i] = new HinhChuNhat();
			hcn[i].setDaiRong(chieuDai, chieuRong);
		}
		
		System.out.println("\nChieu dai, chieu rong va dien tich cua cac hinh chu nhat: \n");
		double max = 0;
		for(int i = 0; i < n; i++){
			System.out.println(hcn[i]);
			if(max < hcn[i].dientichHCN()){
				max = hcn[i].dientichHCN();
			}
		}
		System.out.println("Hinh chu nhat co dien tich lon nhat: " + max);
		input.close();
	}

}
