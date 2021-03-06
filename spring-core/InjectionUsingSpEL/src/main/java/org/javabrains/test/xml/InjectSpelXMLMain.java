/**
 * 
 */
package org.javabrains.test.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Yashoda
 *
 */
public class InjectSpelXMLMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * AbstractApplicationContext context = new
		 * ClassPathXmlApplicationContext( "spring.xml");
		 * context.registerShutdownHook();
		 */

		// Alternative to AbstractApplicationContext
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:spring.xml");
		context.refresh();

		Logger logger = LoggerFactory.getLogger("InjectSpel");

		IProfile profile = null;

		profile = context.getBean("newMember", IProfile.class);

		logger.info(profile.toString());

		logger.info("Message logged");
		context.close();

	}

}
