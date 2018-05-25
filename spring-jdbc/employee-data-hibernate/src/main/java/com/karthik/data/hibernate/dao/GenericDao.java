package com.karthik.data.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T,K> {
	
	List<T> getAll();
	
	T get(Serializable id);
	
	Serializable add(T entity);
	
	void update(T entity);
	
	void delete(T entity);
	
	void deleteById(K id);

}
