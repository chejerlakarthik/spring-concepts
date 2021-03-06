/**
 * 
 */
package org.javabrains.test.main;

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
		String argument = null;

		if (args.length > 0)
			argument = args[0];

		if (!(null == argument)) {
			if (argument.equalsIgnoreCase("Triangle"))
				shape = context.getBean("triangle", Shape.class);
			else if (argument.equalsIgnoreCase("Rectangle"))
				shape = context.getBean("rectangle", Shape.class);
			else
				logger.error("Invalid Input");
			System.out.println("Shape is : " + shape.getClass().getSimpleName()
					+ "  " + shape.calculateArea());
			logger.info("Message logged");

		}

		context.close();
	}

}
