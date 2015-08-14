package org.javabrains.spring.jdbc.template;

import java.util.List;

import org.javabrains.spring.jdbc.beans.Contact;

public interface IContactDao {

	public List<Contact> displayContactWithDetail();

}
