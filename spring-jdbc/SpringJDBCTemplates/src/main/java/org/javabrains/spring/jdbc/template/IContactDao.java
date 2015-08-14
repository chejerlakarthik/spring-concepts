package org.javabrains.spring.jdbc.template;

import java.util.List;

import org.javabrains.spring.jdbc.beans.Contact;

public interface IContactDao {

	public int insert(Contact contact);

	public int update(Contact contact);

	public int delete(Contact contact);

	public List<Contact> displayAll();

	public Contact displayByName(String name);
	
	public int recordCount();
}
