package com.tiad.SchoolDiary.persistence.dao;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.TypedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public abstract class GenericDao<T> extends HibernateDaoSupport  {
	
	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public GenericDao() {
		try{
		System.out.println("GenericDao ->  sessionFactory is: " + getSessionFactory().toString());
	       setPersistentClass((Class<T>) ((ParameterizedType) getClass()
	             .getGenericSuperclass()).getActualTypeArguments()[0]);
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Autowired
    public void init(SessionFactory factory) {
        setSessionFactory(factory);
    }

	/**
	 * Save an object to the database
	 */
	public void save(T c) {
		System.out.println("save ->  sessionFactory is: " + getSessionFactory().toString());
		/*Session currentSession = getSessionFactory().getCurrentSession();
		currentSession.saveOrUpdate(c);*/
		getHibernateTemplate().save(c);
	}

	/**
	 * read an object from the database by an id
	 */
	@SuppressWarnings("unchecked")
	public T getById(long id) {
		/*Session currentSession = getSessionFactory().getCurrentSession();
		T c = null;
		try {
			c = (T) currentSession.createCriteria(getPersistentClass())
					.add(Restrictions.idEq(id)).uniqueResult();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		return c;*/
		
		DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass());
		return (T) getHibernateTemplate().findByCriteria(criteria).get((int) id);
	}	

	/**
	 * Delete an object from the database by an id
	 */
	@SuppressWarnings("unchecked")
	public void deleteById(long id) {
		Session currentSession = getSessionFactory().getCurrentSession();

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
