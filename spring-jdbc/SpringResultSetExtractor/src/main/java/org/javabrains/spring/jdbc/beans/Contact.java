/**
 * 
 */
package org.javabrains.spring.jdbc.beans;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Yashoda
 *
 */
@Component
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long contactId;
	private String firstName;
	private String lastName;
	private String workCompany;
	private List<ContactDetail> contactDetails;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the workCompany
	 */
	public String getWorkCompany() {
		return workCompany;
	}

	/**
	 * @param workCompany
	 *            the workCompany to set
	 */
	public void setWorkCompany(String workCompany) {
		this.workCompany = workCompany;
	}

	/**
	 * @return the contactDetails
	 */
	public List<ContactDetail> getContactDetails() {
		return contactDetails;
	}

	/**
	 * @param contactDetails
	 *            the contactDetails to set
	 */
	public void setContactDetails(List<ContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "Contact [contactId=" + contactId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", workCompany=" + workCompany
				+ ", contactDetails=" + contactDetails + "]";
	}

}
