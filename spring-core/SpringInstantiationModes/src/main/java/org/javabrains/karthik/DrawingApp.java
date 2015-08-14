package org.javabrains.karthik;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		context.registerShutdownHook();

		Triangle triangle1 = context.getBean("triangle", Triangle.class);
		Triangle triangle2 = context.getBean("triangle", Triangle.class);

		System.out.println(triangle1.getBase() + " " + triangle1.getHeight());
		System.out.println(triangle2.getBase() + " " + triangle2.getHeight());

		System.out.println("Object Equality check:" + (triangle1 == triangle2));
		System.out.println("Value Equality check:"
				+ (triangle1.getBase() == triangle2.getBase()) + " "
				+ (triangle1.getHeight() == triangle2.getHeight()));

		context.close();

		/*
		 * BeanFactory beanFactory = new XmlBeanFactory(new
		 * FileSystemResource("spring.xml")); Triangle triangle = (Triangle)
		 * beanFactory.getBean("triangle"); triangle.draw();
		 */
	}

}
