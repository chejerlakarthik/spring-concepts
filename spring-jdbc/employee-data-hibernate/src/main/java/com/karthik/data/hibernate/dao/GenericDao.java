package com.karthik.data.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T,PK extends Serializable> {
	
	List<T> findAll();
	
	T findById(PK id, boolean lock);
	
	T makePersistent(T entity);
	
	void makeTransient(T entity);
	
	void addList(List<T> departments);

}
