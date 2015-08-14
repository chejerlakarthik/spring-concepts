package org.javabrains.spring.jdbc.template;

import java.util.List;

import org.javabrains.spring.jdbc.beans.Contact;

public interface IContactDao {

	public void insert(Contact contact);

	public void update(Contact contact);

	public void delete(Contact contact);

	public List<Contact> displayAll();

	public List<Contact> displayByName(String name);
}
