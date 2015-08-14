/**
 * 
 */
package org.javabrains.test.xml;

import org.javabrains.test.xml.Shape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Yashoda
 *
 */
public class AreaCalculatorXMLMain {

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

		Logger logger = LoggerFactory.getLogger("AreaCalculatorLogger");

		Shape shape = null;
		
		shape = context.getBean("rectangle", Shape.class);
		shape.calculateArea();

		logger.info(shape.toString());
		
		logger.info("Message logged");

		context.close();

	}

}
