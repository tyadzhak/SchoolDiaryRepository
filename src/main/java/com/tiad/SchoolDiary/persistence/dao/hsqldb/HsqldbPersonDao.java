package com.tiad.SchoolDiary.persistence.dao.hsqldb;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
@Repository
@Transactional
public class HsqldbPersonDao extends GenericDao<PersonEntityImpl> implements PersonDao<PersonEntityImpl>{

}
