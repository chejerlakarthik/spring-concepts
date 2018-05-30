package com.karthik.data.hibernate.finder.impl;

import java.lang.reflect.Method;

import com.karthik.data.hibernate.finder.FinderNamingStrategy;

/**
 * Looks up Hibernate named queries based on the simple name of the invoked
 *  class and the method name of the invocation
 */
public class SimpleFinderNamingStrategy implements FinderNamingStrategy {

	@Override
	public String queryNameFromMethod(Class findTargetType, Method finderMethod) {
		return findTargetType.getSimpleName() + "." + finderMethod.getName();
	}

}
