/**
 * 
 */
package org.javabrains.test.xml;

/**
 * @author Yashoda
 *
 */
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
		return (double) (0.5 * base * height);
	}

}
