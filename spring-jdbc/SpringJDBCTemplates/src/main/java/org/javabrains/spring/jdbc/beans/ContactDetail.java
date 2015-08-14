/**
 * 
 */
package org.javabrains.spring.jdbc.beans;

import java.io.Serializable;

/**
 * @author Yashoda
 *
 */
public class ContactDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long contactId;
	private String telType;
	private String telNumber;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the contactId
	 */
	public Long getContactId() {
		return contactId;
	}

	/**
	 * @param contactId
	 *            the contactId to set
	 */
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	/**
	 * @return the telType
	 */
	public String getTelType() {
		return telType;
	}

	/**
	 * @param telType
	 *            the telType to set
	 */
	public void setTelType(String telType) {
		this.telType = telType;
	}

	/**
	 * @return the telNumber
	 */
	public String getTelNumber() {
		return telNumber;
	}

	/**
	 * @param telNumber
	 *            the telNumber to set
	 */
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

}
