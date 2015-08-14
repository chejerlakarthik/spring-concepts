/**
 * 
 */
package org.javabrains.spring.jdbc.datasource;

import java.sql.Date;

import org.javabrains.spring.jdbc.beans.Contact;
import org.javabrains.spring.jdbc.template.IContactDao;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Yashoda
 *
 */
public class TesterDataSource {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.registerShutdownHook();
		context.load("spring.xml");
		context.refresh();

		IContactDao contactDao = context.getBean("JdbcContactDao",
				JdbcContactDao.class);

		Contact contact = new Contact();
		contact.setId((long) 5);
		contact.setFirstName("Aarthi");
		contact.setLastName("Sundar");
		contact.setDateOfBirth(new Date(123226585));

		contactDao.insert(contact);

		System.out.println(contactDao.displayAll());

		contact.setLastName("Chejerla");
		contactDao.update(contact);

		System.out.println(contactDao.displayByName("Aarthi"));

		contact.setLastName("Kapoor");
		contactDao.delete(contact);

		System.out.println(contactDao.displayAll());

		// System.out.println("# of records in table: " +
		// contactDao.recordCount());
		context.close();
	}
}
