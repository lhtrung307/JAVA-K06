package inputexception;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ExampleRealNum {

	//Chuyen try...catch vao trong vong lap do...while de thuc hien duoc nhieu lan.
	public static void main(String[] args) {
			int numA, numB;
			int choose = 0;
			double result = 0.0;
			String c;
			Scanner input = new Scanner(System.in);
		do{
			try{
				System.out.println("-----CHOOSE-----");
				System.out.println("1. Sum");
				System.out.println("2. Subtract");
				System.out.println("3. Multiply");
				System.out.println("4. Divide");
				System.out.println("0. Thoat");
				System.out.println("Nhap vao phep tinh muon thuc hien: ");
				
				choose = input.nextInt();
				
				System.out.println("Input number: ");
				numA = input.nextInt();
				System.out.println("Input number: ");
				numB= input.nextInt();
				
				switch(choose){
					case 1:
						result = numA + numB;
						break;
					case 2:
						result = numA - numB;
						break;
					case 3:
						result = numA * numB;
						break;
					case 4:
						result = numA / numB; //Neu ep kieu thi khong xuat hien loi chia cho 0;
				}
				System.out.println("Result: " + result);
				System.out.println("Nhan 0 de ket thuc chuong trinh, nhan phim khac de tiep tuc");
				choose = input.nextInt();
			}catch(ArithmeticException e){
				System.err.println("Loi chia cho 0");
			}catch(InputMismatchException e){
				System.err.println("Nhap lieu sai");
				c = input.nextLine();
			}
		}while(choose > 0 && choose < 5);
		
		input.close();
	}

}
