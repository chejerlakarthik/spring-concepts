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
	@Autowired
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
	@Autowired
	public void setDimensionTwo(long dimensionTwo) {
		this.dimensionTwo = dimensionTwo;
	}

	@Override
	public double calculateArea() {
		return (double) (dimensionOne * dimensionTwo);
	}

}
