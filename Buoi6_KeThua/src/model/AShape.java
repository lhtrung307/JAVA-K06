package model;

public abstract class AShape {
	protected Position p;

	public AShape(double x, double y){
		p = new Position(x, y);
	}
	
	public AShape(Position p) {
		this.p = p;
	}

	public Position getP() {
		return p;
	}

	public void setP(Position p) {
		this.p = p;
	}
	
	public double distanceToO(){
		return this.getP().distanceToO();
	}
	
	public abstract double area();
	
}
