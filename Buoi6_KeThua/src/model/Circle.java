package model;

public class Circle extends AShape{
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Circle(Position p, double radius) {
		super(p);
		this.radius = radius;
	}

	public double area() {
		return this.getRadius() * this.getRadius();
	}
}
