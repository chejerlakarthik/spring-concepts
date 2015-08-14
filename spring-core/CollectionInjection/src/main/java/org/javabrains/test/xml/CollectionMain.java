/**
 * 
 */
package org.javabrains.test.xml;

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
		context.load("spring.xml");
		context.refresh();

		CollectionBean collectionInstance = context.getBean("collectionBean",
				CollectionBean.class);
		collectionInstance.displayInfo();

		context.close();
	}

}
