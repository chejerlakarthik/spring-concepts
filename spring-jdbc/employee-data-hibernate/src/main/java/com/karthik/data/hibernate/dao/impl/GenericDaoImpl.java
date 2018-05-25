package com.karthik.data.hibernate.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.karthik.data.hibernate.dao.GenericDao;

public class GenericDaoImpl<T,K> implements GenericDao<T,K> {

	private Class<T> type;
	private SessionFactory sessionFactory;
	
	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	@Override
	public List<T> getAll() {
		// Obtain criteria builder and subsequently, criteria query from it
		CriteriaQuery<T> criteria = getSession().getCriteriaBuilder().createQuery(type);
		// Specify criteria root
		criteria.from(type);
		// Execute the criteria query with the session
		List<T> listOfEntities = getSession().createQuery(criteria).getResultList();
		return listOfEntities;
	}

	@Override
	public T get(Serializable id) {
		return getSession().get(type, id);
	}

	@Override
	public Serializable add(T entity) {
		Integer id = (Integer) getSession().save(entity);
		return id;
	}

	@Override
	public void update(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().remove(entity);
	}

	@Override
	public void deleteById(K id) {
		T entity = getSession().find(type, id);
		if (null != entity) {
			delete(entity);
		}
	}

}
