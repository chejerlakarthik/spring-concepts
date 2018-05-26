package com.karthik.data.hibernate.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ApplicationService<T,PK extends Serializable> {
	
	List<T> getAll();
	
	T get(PK id);
	
	T add(T entity);
	
	void delete(T entity);
	
	void deleteById(PK id);
	
	void update(T entity);

}
