package it.unibs.fp.planetarium;

public class Punto {
	private double x;
	private double y;
	
	public Punto(double _x, double _y) {
		this.x = _x;
		this.y = _y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String toString() {
		return String.format("(%.2f; %.2f)", this.x, this.y);
	}

}