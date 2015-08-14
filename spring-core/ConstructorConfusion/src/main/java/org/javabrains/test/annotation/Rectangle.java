/**
 * 
 */
package org.javabrains.test.annotation;

import org.javabrains.test.annotation.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yashoda
 *
 */
@Service
public class Rectangle implements Shape {

	private String dimension;

	public Rectangle() {
		this.dimension = "10";
	}

	public Rectangle(String dimension) {
		this.dimension = dimension;
		System.out.println("String Constructor");
	}

	/*
	 * The constructor which is overridden with @Autowired annotation is wired
	 * automatically by Spring.
	 */
	@Autowired
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
