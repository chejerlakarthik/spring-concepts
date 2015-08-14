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

	public Rectangle(){
		this.dimensionOne = 10;
		this.dimensionTwo = 20;
	}
	public Rectangle(long dimensionOne, long dimensionTwo) {
		this.dimensionOne = dimensionOne;
		this.dimensionTwo = dimensionTwo;
	}

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
		System.out.println("Rectangle : " + (double) (dimensionOne * dimensionTwo));
		return (double) (dimensionOne * dimensionTwo);
	}

}
