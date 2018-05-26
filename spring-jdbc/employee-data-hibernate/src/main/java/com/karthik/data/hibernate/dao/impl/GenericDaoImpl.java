package com.karthik.data.hibernate.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.karthik.data.hibernate.dao.GenericDao;

public class GenericDaoImpl<T,PK extends Serializable> implements GenericDao<T,PK> {

	private Class<T> persistentClass;
	private SessionFactory sessionFactory;
	
	public GenericDaoImpl() {}
	
	public GenericDaoImpl(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
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
	public List<T> findAll() {
		// Obtain criteria builder and subsequently, criteria query from it
		CriteriaQuery<T> criteria = getSession().getCriteriaBuilder().createQuery(getPersistentClass());
		// Specify criteria root
		criteria.from(getPersistentClass());
		// Execute the criteria query with the session
		List<T> entityList = getSession().createQuery(criteria).getResultList();
		return entityList;
	}

	@Override
	public T makePersistent(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public void makeTransient(T entity) {
		getSession().remove(entity);
	}

	@Override
	public T findById(PK id, boolean lock) {
		T entity;
		if (lock) {
			entity = getSession().load(getPersistentClass(), id, LockOptions.UPGRADE);
		} else {
			entity = getSession().load(getPersistentClass(), id);
		}
		return entity;
	}
	
	public void flush() {
		getSession().flush();
	}
	
	public void clear() {
		getSession().clear();
	}

	@Override
	public void addList(List<T> entities) {
		for (T entity : entities) {
			this.makePersistent(entity);
		}
	}

}
