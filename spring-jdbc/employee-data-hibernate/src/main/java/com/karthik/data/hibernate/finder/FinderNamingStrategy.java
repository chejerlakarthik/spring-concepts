package com.karthik.data.hibernate.finder;

import java.lang.reflect.Method;

public interface FinderNamingStrategy {
	
	public String queryNameFromMethod(Class findTargetType, Method finderMethod);

}
