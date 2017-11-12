package test;

public class Test {
	public static void main(String[] args) {
		System.out.println(test());
	}
	
	public static void test2(){
		System.out.println(5/0);
	}

	public static String test(){
		try{
			String test = "NNLT Huong Doi Tuong";
//			System.out.println(test.substring(50));
			System.out.println(test.substring(5));
			int a = 5;
			int b = 0;
//			System.out.println(a/b);
			test2();
			return "return try";
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("Loi: " + e.toString());
		}catch(ArithmeticException e1){
			System.out.println("Loi: " + e1.toString());
		}
//		System.out.println("sau");
//		return "return end";
	}
}
