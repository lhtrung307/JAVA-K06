package nhapxuat;

import java.util.Scanner;

public class TheScanner {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Input your name: ");
		String fullName = input.nextLine();
		
		System.out.println("Input your ID: ");
		String studentID = input.nextLine();
		
		System.out.println("Input your GPA: ");
		double gpa = input.nextDouble();
		
		System.out.println("-----STUDENT-----");
		System.out.println("Name: " + fullName);
		System.out.println("ID: " + studentID);
		System.out.println("GPA: " + gpa);
		input.close();
	}
}
