package stringmethods;

import java.util.Scanner;

public class CatChuoi {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap vao chuoi: ");
		String newStr = input.nextLine();
		newStr = newStr.replaceAll(" ", "");
		System.out.println(newStr.trim());
//		String[] tu = input.nextLine().split(" ");
//		String tuDaiNhat = "";
//		int doDaiTuDaiNhat = 0;
//		for (String string : tu) {
//			if(string.length() > doDaiTuDaiNhat){
//				doDaiTuDaiNhat = string.length();
//				tuDaiNhat = string;
//			}
//		}
//		System.out.println("Tu dai nhat la: " + tuDaiNhat);
		input.close();
	}

	private static void append(String string) {
		// TODO Auto-generated method stub
		
	}

}
