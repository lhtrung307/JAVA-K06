package model;

public class Square extends AShape {
	private double size;

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public Square(Position p, double size) {
		super(p);
		this.size = size;
	}

	public double area() {
		return this.getSize() * this.getSize();
	}
	
	
}
