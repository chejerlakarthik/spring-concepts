/**
 * 
 */
package org.javabrains.spring.jdbc.datasource;

import java.util.List;

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
		List<Contact> list = contactDao.displayContactWithDetail();

		for (Contact contact : list) {
			System.out.println(contact);
		}
		context.close();
	}
}
