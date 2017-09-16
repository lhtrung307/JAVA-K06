package model;

public class Test {

	public static void main(String[] args) {
		Position p = new Position(3, 3);
		
		AShape a1 = new Circle(p, 5);
		
		AShape a2 = new Rectangel(p, 15, 10);
		
		AShape a3 = new Square(p, 20);
		
		AShape a4 = new Dot(new Position(5, 5));
		System.out.println(a1.area());
		System.out.println(a2.area());
		System.out.println(a3.area());
		System.out.println(a4.area());
		System.out.println(a1.distanceToO());
		System.out.println(a4.distanceToO());
	}

}
