package com.karthik;

public class Rectangle implements Shape {

	private double length;
	private double breadth;

	public Rectangle(double length, double breadth) {
		this.length = length;
		this.breadth = breadth;
	}

	public Rectangle() {
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getBreadth() {
		return breadth;
	}

	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", breadth=" + breadth + "]";
	}

	@Override
	public double getArea(double[] inputs) {
		assert inputs.length==2;
		return inputs[0]*inputs[1];
	}

	@Override
	public double getPerimeter(double[] inputs) {
		assert inputs.length==2;
		return 2 * (inputs[0] + inputs[1]);
	}

}
