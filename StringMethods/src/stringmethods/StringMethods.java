package stringmethods;

public class StringMethods {

	public static void main(String[] args) {
		String str = "Hoang Trung";
		
		//Khoi tao mot chuoi bang mot chuoi
		String str1 = new String("Hoang Trung");
		//Khoi tao mot chuoi bang mot mang char 
		char[] value = { 'H', 'o', 'a', 'n', 'g', ' ', 'T', 'r', 'u', 'n', 'g'};
		String str2 = new String(value);
		//hoac la mot phan mang char
//		String newStr = new String(value, 5, 5);
		System.out.println(str2.trim());
		int num = 100;
		str2 += String.valueOf(num);
		System.out.println(str2);
	}

}
