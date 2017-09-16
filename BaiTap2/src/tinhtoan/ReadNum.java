package tinhtoan;

import java.util.Scanner;

public class ReadNum {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input number");
		int num = input.nextInt();
		String readNum = "";
		do {
			
			switch (num % 10) {
				case 1:
					readNum = "Mot " + readNum;
					break;
				case 2:
					readNum = "Hai " + readNum;
					break;
				case 3:
					readNum = "Ba " + readNum;
					break;
				case 4:
					readNum = "Bon " + readNum;
					break;
				case 5:
					readNum = "Nam " + readNum;
					break;
				case 6:
					readNum = "Sau " + readNum;
					break;
				case 7:
					readNum = "Bay " + readNum;
					break;
				case 8:
					readNum = "Tam " + readNum;
					break;
				case 9:
					readNum = "Chin " + readNum;
					break;
				case 0:
					readNum = "Khong " + readNum;
					
					break;
		
				default:
					break;
			}
			num /= 10;
		} while (num > 0);

		System.out.println(readNum);
		
		input.close();
	}

}
