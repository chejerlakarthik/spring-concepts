package com.karthik.data.hibernate.finder.impl;

import org.hibernate.type.Type;

import com.karthik.data.hibernate.finder.FinderArgumentTypeFactory;

public class SimpleFinderArgumentTypeFactory implements FinderArgumentTypeFactory {

	@Override
	public Type getArgumentType(Object arg) {
		return null;
	}

}
