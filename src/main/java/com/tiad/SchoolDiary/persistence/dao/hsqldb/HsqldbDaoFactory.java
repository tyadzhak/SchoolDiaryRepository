package com.tiad.SchoolDiary.persistence.dao.hsqldb;

import com.tiad.SchoolDiary.persistence.dao.DaoFactory;
import com.tiad.SchoolDiary.persistence.dao.PersonDao;

public class HsqldbDaoFactory extends DaoFactory{

	@Override
	public PersonDao getPersonDao() {
		return new HsqldbPersonDao();
	}
}
