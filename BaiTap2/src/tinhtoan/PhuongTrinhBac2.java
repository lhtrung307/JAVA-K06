package tinhtoan;

import java.util.Scanner;

public class PhuongTrinhBac2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double a, b, c;
		
		System.out.println("Nhap he so a: ");
		a = input.nextDouble();
		System.out.println("Nhap he so b: ");
		b = input.nextDouble();
		System.out.println("Nhap he so c: ");
		c = input.nextDouble();
		
		if(a != 0){
			if(b != 0){
				if(c != 0){
					double delta = b * b - 4 * a * c;
					if(delta > 0){
						System.out.println("Phuong trinh co hai nghiem: x1 = " + ((-b + Math.sqrt(delta)) / (2 * a)) + "\tx2 = " + ((-b - Math.sqrt(delta)) / (2 * a)) );
					}
					else if(delta == 0){
						System.out.println("Phuong trinh co nghiem kep: x = " + (-b / (2 * a)));
					}
					else{
						System.out.println("Phuong trinh vo nghiem!!!");
					}
				}
			}
//			else{
//				System.out.println((c != 0) ? String.format("Phuong trinh co hai nghiem x1 = %f, x2 = %f", (Math.sqrt(-c / a)), -(Math.sqrt(-c / a)) ): "Phuong trinh co vo so nghiem!!!");
//			}
		}
		else{
//			if(b != 0){
//				System.out.println((c != 0) ? String.format("Phuong trinh co mot nghiem x = %f",(-c / b)): "Phuong trinh co nghiem x = 0");
//			}
//			else{
//				System.out.println((c != 0) ? "Phuong trinh vo nghiem!!!": "Phuong trinh co vo so nghiem!!!");
//			}
			System.out.println("Khong phai phuong trinh bac hai!!!");
		}
		input.close();
	}
	

}
