package tinhtoan;

import java.util.Scanner;

public class Triangle {

	public static double distance(double xA, double yA, double xB, double yB){
		return Math.sqrt(Math.pow((xA - xB), 2) + Math.pow((yA - yB), 2));
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Input point A: ");
		double xA = input.nextDouble();
		double yA = input.nextDouble();
		System.out.println("Input point B: ");
		double xB = input.nextDouble();
		double yB = input.nextDouble();
		System.out.println("Input point C: ");
		double xC = input.nextDouble();
		double yC = input.nextDouble();
		
		double edgeAB = Triangle.distance(xA, yA, xB, yB);
		double edgeAC = Triangle.distance(xA, yA, xC, yC);
		double edgeBC = Triangle.distance(xB, yB, xC, yC);
		
//		System.out.println(edgeAB);
//		System.out.println(edgeAC);
//		System.out.println(edgeBC);
		
		
		if((edgeAB + edgeAC > edgeBC) && (edgeAB + edgeBC > edgeAC) && (edgeBC + edgeAC > edgeAB)){
			System.out.println("It's a triangle!!");
			System.out.println((edgeAB == edgeAC) || (edgeAB == edgeBC) || (edgeAC == edgeBC) ? "Isosceles" : "Not Isosceles");
			double perimeter = edgeAB + edgeAC + edgeBC;
			System.out.println("Perimeter: " + perimeter);
			
			double p = perimeter / 2;
			double acreage = Math.sqrt(p * (p - edgeAB) * (p - edgeAC) * (p - edgeBC));
			System.out.println("Acreage: " + acreage);
		}
		else{
			System.out.println("It's not a triangle!!");
		}
		input.close();
	}
}
