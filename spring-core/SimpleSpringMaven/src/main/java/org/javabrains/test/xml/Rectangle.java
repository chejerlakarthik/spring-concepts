/**
 * 
 */
package org.javabrains.test.xml;


/**
 * @author Yashoda
 *
 */
public class Rectangle implements Shape {

	private long dimensionOne;
	private long dimensionTwo;

	/**
	 * @return the dimensionOne
	 */
	public long getDimensionOne() {
		return dimensionOne;
	}

	/**
	 * @param dimensionOne
	 *            the dimensionOne to set
	 */
	public void setDimensionOne(long dimensionOne) {
		this.dimensionOne = dimensionOne;
	}

	/**
	 * @return the dimensionTwo
	 */
	public long getDimensionTwo() {
		return dimensionTwo;
	}

	/**
	 * @param dimensionTwo
	 *            the dimensionTwo to set
	 */
	public void setDimensionTwo(long dimensionTwo) {
		this.dimensionTwo = dimensionTwo;
	}

	@Override
	public double calculateArea() {
		return (double) (dimensionOne * dimensionTwo);
	}

}
