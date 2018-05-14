package com.karthik;

public class Circle {
	
	private double radius;
	
	public Circle(double radius){
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
	public double getArea(double radius){
		if (radius < 10.0){
			throw new IllegalArgumentException("Radius should be > 10.0");
		}
		double area = Math.PI * Math.pow(radius,2);
		return area;
	}

}
