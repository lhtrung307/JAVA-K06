package nhapxuat;

import java.util.Scanner;

public class Operation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Input a number: ");
		int a = input.nextInt();
		System.out.println("Input a number: ");
		int b = input.nextInt();
		
		System.out.println("Sum: " + (a + b));
		System.out.println("Subtract: " + (a - b));
		System.out.println("Multiply: " + (a * b));
		System.out.println("Divide: " + (a / b));
		input.close();
	}

}
