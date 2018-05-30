package com.karthik.data.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T,PK extends Serializable> {
	
	T read(PK id);
	
	T create(T entity);
	
	void update(T entity);
	
	void delete(T entity);
	
	void createList(List<T> entities);

}
