package com.karthik;

public class Triangle implements Shape{

	public void draw(int i) {
		System.out.println("Drawing Triangle-" + String.valueOf(i));
	}
	
	public void init() {
		System.out.println("Created a triangle bean");
	}

}
