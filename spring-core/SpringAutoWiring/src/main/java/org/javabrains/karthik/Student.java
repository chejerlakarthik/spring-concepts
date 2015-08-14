/**
 * 
 */
package org.javabrains.karthik;

/**
 * @author Yashoda
 *
 */
public class Student {

	private String name;
	private Address homeAddress;
	private Address workAddress;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the homeAddress
	 */
	public Address getHomeAddress() {
		return homeAddress;
	}

	/**
	 * @param homeAddress
	 *            the homeAddress to set
	 */
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	/**
	 * @return the schoolAddress
	 */
	public Address getWorkAddress() {
		return workAddress;
	}

	/**
	 * @param schoolAddress
	 *            the schoolAddress to set
	 */
	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", homeAddress="
				+ homeAddress.toString() + ", schoolAddress="
				+ workAddress.toString() + "]";
	}

}
