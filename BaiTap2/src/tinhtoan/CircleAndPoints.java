package tinhtoan;

import java.util.Scanner;

public class CircleAndPoints {

	public static void main(String[] args) {
		int n;
		double[] x;
		double[] y;
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap vao so luong diem");
		n = input.nextInt();
		x = new double[n];
		y = new double[n];
		
		double rMax = 0;
		double rTemp = 0;
		for(int i = 0; i < n; i++){
			System.out.println("Nhap vao toa do x[" + (i + 1) + "]");
			x[i] = input.nextDouble();
			System.out.println("Nhap vao toa do y[" + (i + 1) + "]");
			y[i] = input.nextDouble();
			rTemp = Math.sqrt(x[i] * x[i] + y[i] * y[i]);
			rMax = (rMax < rTemp) ? rTemp : rMax; 
		}
		
		double s = Math.PI * rMax * rMax;
		System.out.println("Dien tich hinh trong nho nhat chua tat ca cac diem: " + s);
		input.close();
	}

}
