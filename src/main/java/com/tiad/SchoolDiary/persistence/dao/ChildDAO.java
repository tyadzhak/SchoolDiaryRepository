package com.tiad.SchoolDiary.persistence.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiad.SchoolDiary.persistence.model.Child;

@Repository
@Transactional
/*
 * @Repository is one from Spring and it’s pretty straight-forward. It’s used to
 * mark the Java file as something Spring calls a “Component”, which enables it
 * to be scanned and incorporated into Spring’s code. You really just need to
 * remember to put this annotation in all of your DAOs (on the class level) and
 * you’ll be good to go.
 * 
 * @Transactional is used as a means to enable transaction management within
 * your Java DAO file.
 */
public class ChildDAO {
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Save a Child object to the database
	 */
	public void save(Child c) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(c);
	}

	/**
	 * read a Child from the database by an id
	 */
	public Child getById(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Child c = null;
		try {
			c = (Child) currentSession.createCriteria(Child.class)
					.add(Restrictions.idEq(id)).uniqueResult();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		return c;
	}

	/**
	 * Delete a Child object from the database by an id
	 */
	public void deleteById(long id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Child c = null;
		try {
			c = (Child) currentSession.createCriteria(Child.class)
					.add(Restrictions.idEq(id)).uniqueResult();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

		if (c != null) {
			currentSession.delete(c);
		}
	}
}
