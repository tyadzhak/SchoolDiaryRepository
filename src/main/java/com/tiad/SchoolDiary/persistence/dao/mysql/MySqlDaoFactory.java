package com.tiad.SchoolDiary.persistence.dao.mysql;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.tiad.SchoolDiary.persistence.dao.DaoFactory;
import com.tiad.SchoolDiary.persistence.dao.PersonDao;

//@Repository
public class MySqlDaoFactory extends DaoFactory{

	@Bean
	@Override
	public PersonDao getPersonDao() {
		return new MySqlPersonDao();
	}
}
