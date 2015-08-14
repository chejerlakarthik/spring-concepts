/**
 * 
 */
package org.javabrains.spring.jdbc.datasource;

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
		
		IContactDao contactDao = context.getBean("jdbcDAOBean", JdbcContactDao.class);
		
		contactDao.displayAll();
		context.close();
	}
}
