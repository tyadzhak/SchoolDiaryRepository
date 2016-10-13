package com.tiad.SchoolDiary.persistence.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
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
       setPersistentClass((Class<T>) ((ParameterizedType) getClass()
             .getGenericSuperclass()).getActualTypeArguments()[0]);
	}
	
	/**
	 * Save an object to the database
	 */
	public void save(T e) {
		getHibernateTemplate().save(e);
	}

	/**
	 * read an object from the database by an id
	 */
	public T get(long id) {	
		return getHibernateTemplate().get(getPersistentClass(), id);
	}	
	
	public List<T> getAll() {	
		return (List<T>) getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(getPersistentClass()));
	}

	/**
	 * Delete an object from the database by an id
	 */
	public void delete(long id) {
		getHibernateTemplate().delete(get(id));
	}
	
	public void delete(T e) {
		getHibernateTemplate().delete(e);
	}
	
	public boolean isExists(long id){
		return !(get(id) == null);
	}
	
	public void update(T e){
		getHibernateTemplate().update(e);
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
