/**
 * 
 */
package org.javabrains.test.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Yashoda
 *
 */
public class HierarchialAppContextUsage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
		parent.load("spring-parent.xml");
		parent.refresh();
		
		GenericXmlApplicationContext child = new GenericXmlApplicationContext();
		child.load("spring-child.xml");
		child.setParent(parent);
		child.refresh();
		
		SimpleTarget target1 = (SimpleTarget) child.getBean("target1");
		SimpleTarget target2 = (SimpleTarget) child.getBean("target2");
		SimpleTarget target3 = (SimpleTarget) child.getBean("target3");
		
		System.out.println(target1.getValue());
		System.out.println(target2.getValue());
		System.out.println(target3.getValue());

		child.close();
	}

}
