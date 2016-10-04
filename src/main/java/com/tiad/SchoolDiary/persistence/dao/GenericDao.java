package com.tiad.SchoolDiary.persistence.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class GenericDao<T> extends HibernateDaoSupport  {

	@Autowired
	@Qualifier("hibernateTemplate")
	public void init(HibernateTemplate t){
		setHibernateTemplate(t);
	}
	
	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public GenericDao() {
		try{
	       setPersistentClass((Class<T>) ((ParameterizedType) getClass()
	             .getGenericSuperclass()).getActualTypeArguments()[0]);
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Save an object to the database
	 */
	public void save(T c) {
		getHibernateTemplate().save(c);
	}

	/**
	 * read an object from the database by an id
	 */
	public T getById(long id) {	
		return getHibernateTemplate().get(getPersistentClass(), id);
	}	

	/**
	 * Delete an object from the database by an id
	 */
	public void deleteById(long id) {
		T c = null;
		try {
			c = getById(id);
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

		if (c != null) {
			getHibernateTemplate().delete(c);
		}
	}
	
	public boolean isExists(long id){
		return getById(id) != null;
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
