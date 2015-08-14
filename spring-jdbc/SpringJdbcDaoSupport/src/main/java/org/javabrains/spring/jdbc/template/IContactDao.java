package org.javabrains.spring.jdbc.template;

import org.javabrains.spring.jdbc.beans.Contact;

public interface IContactDao {

	public int insert(Contact contact);

}
