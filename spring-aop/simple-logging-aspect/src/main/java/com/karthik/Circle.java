package com.karthik;

public class Circle implements Shape{
	
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
	
	public Double getArea(Double[] inputs){
		assert inputs.length==1;
		if (inputs[0] < 10.0){
			throw new IllegalArgumentException("Radius should be > 10.0");
		}
		double area = Math.PI * Math.pow(radius,2);
		return area;
	}

	public Double getPerimeter(Double[] inputs) {
		assert inputs.length==1;
		return 2 * Math.PI * inputs[0];
	}

}
