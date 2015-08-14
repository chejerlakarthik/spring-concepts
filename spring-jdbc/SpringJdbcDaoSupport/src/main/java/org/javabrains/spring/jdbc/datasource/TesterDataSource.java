/**
 * 
 */
package org.javabrains.spring.jdbc.datasource;

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

		IContactDao contactDao = context.getBean("jdbcContactDao",
				JdbcContactDao.class);

		Contact contact = new Contact();
		contact.setContactId(new Long(400));
		contact.setFirstName("Karthik");
		contact.setLastName("Chejerla");
		contact.setWorkCompany("TCS");
		System.out.println("Inserting contact details");
		contactDao.insert(contact);
		
		context.close();
	}
}
