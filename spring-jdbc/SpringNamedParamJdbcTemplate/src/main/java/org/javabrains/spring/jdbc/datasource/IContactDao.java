package org.javabrains.spring.jdbc.datasource;

import java.util.List;

import org.javabrains.spring.jdbc.beans.Contact;

public interface IContactDao {

	public int insert(Contact contact);

	public int update(Contact contact);

	public int delete(Contact contact);

	public List<Contact> displayAll();

	public Contact displayByFirstName(String name);
	
	public List<Contact> displayContactwithDetail();
	
	public int recordCount();
}
