package org.javabrains.karthik;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		context.registerShutdownHook();

		/*Student karthik = context.getBean("student", Student.class);*/
		Employee employeeKarthik = context.getBean("emp", Employee.class);

		/*System.out.println(karthik.toString());*/
		System.out.println(employeeKarthik.toString());

		context.close();

		/*
		 * BeanFactory beanFactory = new XmlBeanFactory(new
		 * FileSystemResource("spring.xml")); Triangle triangle = (Triangle)
		 * beanFactory.getBean("triangle"); triangle.draw();
		 */
	}

}
