/**
 * 
 */
package org.javabrains.spring.jdbc.datasource;

import java.sql.Date;

import org.javabrains.spring.jdbc.beans.Contact;
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
		
		System.out.println("# of entries in CONTACT table: " + contactDao.displayAll().size());
		
		contact.setId(new Long(5));
		System.out.println("Deleting entries with id > " + contact.getId());
		contactDao.delete(contact);	
		
		System.out.println("# of entries in CONTACT table: " + contactDao.displayAll().size());
		
		contact.setId(new Long(10));
		contact.setFirstName("FFFFFF");
		contact.setLastName("LLLLLL");
		contact.setDateOfBirth(new Date(1515155552));
		System.out.println("Inserting entry : " + contact.toString());
		contactDao.insert(contact);

		System.out.println("# of entries in CONTACT table: " + contactDao.displayAll().size());
		
		contact.setId(new Long(10));
		contact.setFirstName("Karthik");
		contact.setLastName("Chejerla");
		contact.setDateOfBirth(null);
		System.out.println("Updating entry with id= " + contact.getId());
		contactDao.update(contact);
		
		System.out.println("# of entries in CONTACT table: " + contactDao.displayAll().size());

		System.out.println(contactDao.displayByFirstName("Pranamya"));

		context.close();
	}
}
