package com.tiad.SchoolDiary.persistence.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDAO<T> {
	@Autowired
	SessionFactory sessionFactory;
	
	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
	       setPersistentClass((Class<T>) ((ParameterizedType) getClass()
	             .getGenericSuperclass()).getActualTypeArguments()[0]);
	    }

	/**
	 * Save an object to the database
	 */
	public void save(T c) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(c);
	}

	/**
	 * read an object from the database by an id
	 */
	@SuppressWarnings("unchecked")
	public T getById(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		T c = null;
		try {
			c = (T) currentSession.createCriteria(getPersistentClass())
					.add(Restrictions.idEq(id)).uniqueResult();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		return c;
	}

	/**
	 * Delete an object from the database by an id
	 */
	@SuppressWarnings("unchecked")
	public void deleteById(long id) {
		Session currentSession = sessionFactory.getCurrentSession();

		T c = null;
		try {
			c = (T) currentSession.createCriteria(getPersistentClass())
					.add(Restrictions.idEq(id)).uniqueResult();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

		if (c != null) {
			currentSession.delete(c);
		}
	}

	/**
	 * @return the persistentClass
	 */
	protected Class<T> getPersistentClass() {
		return persistentClass;
	}

	/**
	 * @param persistentClass the persistentClass to set
	 */
	private void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
}
