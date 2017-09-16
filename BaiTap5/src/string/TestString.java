package string;

public class TestString{
	public static void main(String[] args) {
		String str1 = "Android.Vn Android.Vn";
		String str2 = "android.vn android.vn";

		System.out.println("So sanh phan biet chu hoa chu thuong: " + str1.equals(str2));
		System.out.println("So sanh khong phan biet chu hoa chu thuong: " + str1.equalsIgnoreCase(str2));

		//So sanh thu tu a,b,c,...
		String str3 = "abc";
		String str4 = "bcde";
		System.out.println("So sanh hai chuoi thuong!");
		System.out.println("" + str3.compareTo(str4));
		System.out.println("" + str4.compareTo(str3));
		System.out.println("" + str3.compareTo(str3));

		System.out.println("So sanh 2 chuoi hoa va thuong");
		String str5 = "ANDroid.Vn";
		String str6 = "android.vn";

		System.out.println("" + str5.compareToIgnoreCase(str6));
		System.out.println("" + str5.compareTo(str6));

		System.out.println("Chuoi nay co la tap con cua chuoi kia khong?");
		String str7 = "android.vn";
		String str8 = "vn";
		System.out.println("Chuoi vn nam o vi tri thu " + str7.indexOf(str8) + " cua chuoi android.vn");

		str8 = "TN";
		System.out.println("Chuoi TN nam o vi tri thu " + str7.indexOf(str8) + " cua chuoi android.vn");

		System.out.println("Chuoi nay co bat dau hay ket thuc bang chuoi kia khong?");
		str7 = "android.vn";
		String str9 = "and";
		String str10 = "roid.vn";
		System.out.println("str7.startsWith(str9) = " + str7.startsWith(str9));
		System.out.println("str7.endsWith(str10) = " + str7.endsWith(str10));
	}
}