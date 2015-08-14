/**
 * 
 */
package org.javabrains.test.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yashoda
 *
 */
@Service
public class Triangle implements Shape {

	private long base;
	private long height;

	public Triangle() {
		this.base = 100;
		this.height = 50;
	}

	@Autowired
	public Triangle(long base, long height) {
		this.base = base;
		this.height = height;
	}

	/**
	 * @return the base
	 */
	public long getBase() {
		return base;
	}

	/**
	 * @param base
	 *            the base to set
	 */
	public void setBase(long base) {
		this.base = base;
	}

	/**
	 * @return the height
	 */
	public long getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(long height) {
		this.height = height;
	}

	@Override
	public double calculateArea() {
		System.out.println("Triangle : " + (double) (0.5 * base * height));
		return (double) (0.5 * base * height);
	}

}
