package tinhtoan;

import java.util.Scanner;

public class MonthOfYear {

	public static void main(String[] args) {
		int month;
		int kt = 1;
		Scanner input = new Scanner(System.in);
		do{
			System.out.println("Input month: " );
			month = input.nextInt();
			
			switch(month){
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					System.out.println("31 days");
					break;
				case 4: case 6: case 9: case 11:
					System.out.println("30 days");
					break;
				case 2:
					System.out.println("28 days");
				default:
					System.out.println("Input invalid!!!");
			}
			System.out.println("1. Press any key to continue.");
			System.out.println("2. Press 0 to exit.");
			kt = input.nextInt();
			
		}while(kt != 0);
		input.close();
	}

}
