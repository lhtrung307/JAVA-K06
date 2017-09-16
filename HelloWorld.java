public class HelloWorld{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Time timeObject = new Time();
		System.out.println(timeObject.toMilitary());
		System.out.println(timeObject.toString());
		timeObject.setTime(12, 4, 5);
		System.out.println(timeObject.toMilitary());
		System.out.println(timeObject.toString());
		
	}
}