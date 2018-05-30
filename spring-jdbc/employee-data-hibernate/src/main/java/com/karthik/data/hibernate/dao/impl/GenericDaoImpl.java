package com.karthik.data.hibernate.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.type.Type;

import com.karthik.data.hibernate.dao.GenericDao;
import com.karthik.data.hibernate.finder.FinderArgumentTypeFactory;
import com.karthik.data.hibernate.finder.FinderExecutor;
import com.karthik.data.hibernate.finder.FinderNamingStrategy;
import com.karthik.data.hibernate.finder.impl.SimpleFinderArgumentTypeFactory;
import com.karthik.data.hibernate.finder.impl.SimpleFinderNamingStrategy;

public class GenericDaoImpl<T,PK extends Serializable> implements GenericDao<T,PK>, FinderExecutor<T> {

	private Class<T> persistentClass;
	private SessionFactory sessionFactory;
	private FinderNamingStrategy namingStrategy = new SimpleFinderNamingStrategy();
	private FinderArgumentTypeFactory argumentTypeFactory = new SimpleFinderArgumentTypeFactory();
	
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

//	@Override
//	public List<T> findAll() {
//		// Obtain criteria builder and subsequently, criteria query from it
//		CriteriaQuery<T> criteria = getSession().getCriteriaBuilder().createQuery(getPersistentClass());
//		// Specify criteria root
//		criteria.from(getPersistentClass());
//		// Execute the criteria query with the session
//		List<T> entityList = getSession().createQuery(criteria).getResultList();
//		return entityList;
//	}

	@Override
	public T create(T entity) {
		getSession().save(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		getSession().remove(entity);
	}

	@Override
	public T read(PK id) {
		return getSession().get(persistentClass, id);
	}
	
	public void flush() {
		getSession().flush();
	}
	
	public void clear() {
		getSession().clear();
	}

	@Override
	public void createList(List<T> entities) {
		for (T entity : entities) {
			this.create(entity);
		}
	}

	public FinderNamingStrategy getNamingStrategy() {
		return namingStrategy;
	}

	public void setNamingStrategy(FinderNamingStrategy namingStrategy) {
		this.namingStrategy = namingStrategy;
	}

	public FinderArgumentTypeFactory getArgumentTypeFactory() {
		return argumentTypeFactory;
	}

	public void setArgumentTypeFactory(FinderArgumentTypeFactory argumentTypeFactory) {
		this.argumentTypeFactory = argumentTypeFactory;
	}
	
	public List<T> executeFinder(Method method, final Object[] queryArgs)
	{
		final Query<T> namedQuery = prepareQuery(method, queryArgs);
		return (List<T>) namedQuery.list();
	}

    public Iterator<T> iterateFinder(Method method, final Object[] queryArgs)
	{
		final Query<T> namedQuery = prepareQuery(method, queryArgs);
		return (Iterator<T>) namedQuery.getResultList().iterator();
	}

    @SuppressWarnings("unchecked")
	private Query<T> prepareQuery(Method method, Object[] queryArgs)
	{
		final String queryName = getNamingStrategy().queryNameFromMethod(persistentClass, method);
		final Query<T> namedQuery = getSession().getNamedQuery(queryName);
		Set<String> namedParameters = namedQuery.getParameterMetadata().getNamedParameterNames();
		if (namedParameters.size() == 0) {
			setPositionalParams(queryArgs, namedQuery);
		} else {
			List<String> namedParams = new ArrayList<String>(namedParameters);
			setNamedParams(namedParams, queryArgs, namedQuery);
		}
		return namedQuery;
	}

    private void setPositionalParams(Object[] queryArgs, Query<T> namedQuery)
	{
		// Set parameter. Use custom Hibernate Type if necessary
		if (queryArgs != null) {
			for (int i = 0; i < queryArgs.length; i++) {
				Object arg = queryArgs[i];
				Type argType = getArgumentTypeFactory().getArgumentType(arg);
				if (argType != null) {
					namedQuery.setParameter(i, arg, argType);
				} else {
					namedQuery.setParameter(i, arg);
				}
			}
		}
	}

    @SuppressWarnings("rawtypes")
	private void setNamedParams(List<String> namedParams, Object[] queryArgs, Query<T> namedQuery)
	{
		// Set parameter. Use custom Hibernate Type if necessary
		if (queryArgs != null) {
			for (int i = 0; i < queryArgs.length; i++) {
				Object arg = queryArgs[i];
				Type argType = getArgumentTypeFactory().getArgumentType(arg);
				if (argType != null) {
					namedQuery.setParameter(namedParams.get(i), arg, argType);
				} else {
					if (arg instanceof Collection) {
						namedQuery.setParameterList(namedParams.get(i), (Collection) arg);
					} else {
						namedQuery.setParameter(namedParams.get(i), arg);
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return "GenericDaoImpl [persistentClass=" + persistentClass + ", sessionFactory=" + sessionFactory
				+ ", namingStrategy=" + namingStrategy + ", argumentTypeFactory=" + argumentTypeFactory + "]";
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

}
