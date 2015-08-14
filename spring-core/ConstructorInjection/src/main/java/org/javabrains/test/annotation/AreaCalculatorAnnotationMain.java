/**
 * 
 */
package org.javabrains.test.annotation;

import org.javabrains.test.annotation.Shape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Yashoda
 *
 */
public class AreaCalculatorAnnotationMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("spring-annotation.xml");
		context.refresh();

		Logger logger = LoggerFactory.getLogger("AreaCalculatorLogger");

		Shape shape = null;

		shape = context.getBean("triangle", Shape.class);
		shape.calculateArea();

		logger.info(shape.getClass().getSimpleName());

		shape = context.getBean("rectangle", Shape.class);
		shape.calculateArea();

		logger.info(shape.getClass().getSimpleName());

		logger.info("Message logged");

		context.close();
	}

}
