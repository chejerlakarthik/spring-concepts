/**
 * 
 */
package org.javabrains.spring.jdbc.beans;

import java.io.Serializable;
import java.sql.Date;
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
	private static final long serialVersionUID = -3125948833704101182L;

	private Long Id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private List<ContactDetail> contactDetails;

	/**
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		Id = id;
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
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
		return "Contact [Id=" + Id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
