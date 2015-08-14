/**
 * 
 */
package org.javabrains.test.xml;

/**
 * @author Yashoda
 *
 */
public class Rectangle implements Shape {

	private String dimension;

	public Rectangle() {
		this.dimension = "10";
	}

	public Rectangle(String dimension) {
		this.dimension = dimension;
		System.out.println("String Constructor");
	}
	
	public Rectangle(int dimension) {
		this.dimension = Integer.toString(dimension);
		System.out.println("Integer Constructor");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Rectangle [dimension=" + dimension + "]";
	}

	@Override
	public double calculateArea() {
		return 0;
	}

}
