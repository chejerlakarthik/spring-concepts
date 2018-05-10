package com.karthik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Line implements Shape {

	private Point source;
	private Point destination;

	@Autowired
	public Line(Point source, Point destination) {
		this.source = source;
		this.destination = destination;
	}

	public void draw() {
		System.out.println("Drawing a line ....");
	}

	public Point getSource() {
		return source;
	}

	public void setSource(Point source) {
		this.source = source;
	}

	public Point getDestination() {
		return destination;
	}

	public void setDestination(Point destination) {
		this.destination = destination;
	}

}
