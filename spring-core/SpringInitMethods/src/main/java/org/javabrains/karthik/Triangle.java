/**
 * 
 */
package org.javabrains.karthik;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author Yashoda
 *
 */
public class Triangle implements InitializingBean, DisposableBean {

	private double base;
	private double height;

	/**
	 * @return the base
	 */
	public double getBase() {
		return base;
	}

	/**
	 * @param base
	 *            the base to set
	 */
	public void setBase(double base) {
		this.base = base;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	public void myInitMethod() {
		System.out.println("My Init method called using spring.xml");
	}

	public void myDestroyMethod() {
		System.out.println("My Destroy method called using spring.xml");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Triangle [base=" + base + ", height=" + height + "]";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out
				.println("Method afterPropertiesSet called using InitializingBean interface");
	}

	@Override
	public void destroy() throws Exception {
		System.out
				.println("Destroy method called using DisposableBean interface");
	}

}
