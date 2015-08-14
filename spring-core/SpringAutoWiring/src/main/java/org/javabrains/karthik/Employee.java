/**
 * 
 */
package org.javabrains.karthik;

/**
 * @author Yashoda
 *
 */
public class Employee {

	private String name;
	private Address workAddress;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [name=" + name + ", workAddress=" + workAddress
				+ "]";
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the workAddress
	 */
	public Address getWorkAddress() {
		return workAddress;
	}

	/**
	 * @param workAddress
	 *            the workAddress to set
	 */
	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}

}
