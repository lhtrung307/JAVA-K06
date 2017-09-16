package nhapxuat;

import java.util.Scanner;


public class Bai1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ban hay nhap vao mot so: ");
		
		int n = input.nextInt();
		
		System.out.println("Ban da nhap so " + (n % 2 == 0 ? "chan" : "le"));
		
		int num = 5;
		System.out.println(num++);
		System.out.println(++num);
		System.out.println(--num);
		System.out.println(num--);
		System.out.println(num++);
		
		int a = 5;
		int b = 6;
		a += b;
		System.out.println(a);
		a -= b;
		System.out.println(a);
		a *= b;
		System.out.println(a);
		a /= b;
		System.out.println(a);
		a %= b;
		System.out.println(a);
		
		//Cac phep tinh toan hoc khac
		double p = Math.PI;
		double Exp = Math.pow(a, b);
		double canBacHai = Math.sqrt(a);
		double sin = Math.sin(a);
		
		input.close();
	}

}
