package com.tiad.SchoolDiary.persistence.dao.hsqldb;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.tiad.SchoolDiary.persistence.dao.DaoFactory;
import com.tiad.SchoolDiary.persistence.dao.PersonDao;

//@Repository
public class HsqldbDaoFactory extends DaoFactory{

	@Override
	@Bean
	public PersonDao getPersonDao() {
		return new HsqldbPersonDao();
	}
}
