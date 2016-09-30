package com.tiad.SchoolDiary.persistence.dao.hsqldb;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiad.SchoolDiary.persistence.PersistenceConfig;
import com.tiad.SchoolDiary.persistence.dao.GenericDao;
import com.tiad.SchoolDiary.persistence.dao.PersonDao;
import com.tiad.SchoolDiary.persistence.entities.impl.PersonEntityImpl;


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
//@Repository
@Transactional
@Component
public class HsqldbPersonDao extends GenericDao<PersonEntityImpl> implements PersonDao<PersonEntityImpl>{
	
	/*
	@Override
	public int insertPerson(Person p) {
		// TODO Auto-generated method stub
		// Implement insert customer here.
		// Return newly created customer number
		// or a -1 on error
		return 0;
	}

	@Override
	public boolean deletePersin(Person p) {
		// TODO Auto-generated method stub
		// Implement delete customer here
		// Return true on success, false on failure
		return false;
	}

	@Override
	public Person findPerson(Person p) {
		// TODO Auto-generated method stub
		// Implement find a customer here using supplied
		// argument values as search criteria
		// Return a Transfer Object if found,
		// return null on error or if not found
		return null;
	}

	@Override
	public boolean updatePerson(Person p) {
		// TODO Auto-generated method stub
		// implement update record here using data
		// from the customerData Transfer Object
		// Return true on success, false on failure or
		// error
		return false;
	}
*/
}
