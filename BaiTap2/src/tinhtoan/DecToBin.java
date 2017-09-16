package tinhtoan;

import java.util.Scanner;

public class DecToBin {

	public static void main(String[] args) {
		//Input
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		//Handle
		int binNum = 0;
		int i = 0;
		do{
			if((num & 1) == 1){
				binNum += Math.pow(10, i);
			}
			i++;
		}while((num >>= 1) != 0);
		System.out.println(binNum);
		
		//Way 2
		String result = "";
		while(num > 0){
			result = num % 2 + result;
			num /= 2;
		}
		
		//Output
		System.out.println(result);
		
		//Way 3
		for(int j = num; j > 0; j /= 2){
			result = i % 2 + result;
		}
		
		input.close();
	}

}
