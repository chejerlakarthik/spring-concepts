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
	@Autowired
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
	@Autowired
	public void setHeight(long height) {
		this.height = height;
	}

	@Override
	public double calculateArea() {
		return (double) (0.5 * base * height);
	}

}
