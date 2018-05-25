package com.karthik.data.hibernate.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ApplicationService<T> {
	
	List<T> getAll();
	
	T get(Integer id);
	
	Integer add(T entity);
	
	void delete(T entity);
	
	void deleteById(Integer id);
	
	void update(T entity);

}
