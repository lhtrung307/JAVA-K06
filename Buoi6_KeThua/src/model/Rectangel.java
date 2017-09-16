package model;

public class Rectangel extends AShape{
	private double width;
	private double height;
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Rectangel(Position p, double width, double height) {
		super(p);
		this.width = width;
		this.height = height;
	}

	public double area() {
		return this.getHeight() * this.getWidth();
	}
	
}
