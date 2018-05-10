package com.karthik;

import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape {

	private Point center;
	private Integer radius;
	
	public void draw() {
		System.out.println("Drawing a circle...");
	}

	public Point getCenter() {
		return center;
	}
	
	@Required
	public void setCenter(Point center) {
		this.center = center;
	}

	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}

}
