/**
 * 
 */
package org.javabrains.test.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Yashoda
 *
 */
public class CollectionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("spring-annotation.xml");
		context.refresh();

		CollectionBean collectionInstance = context.getBean("collectionBean",
				CollectionBean.class);
		collectionInstance.displayInfo();

		context.close();
	}

}
