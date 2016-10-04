package com.tiad.SchoolDiary.persistence.dao.mysql;

import com.tiad.SchoolDiary.persistence.dao.DaoFactory;
import com.tiad.SchoolDiary.persistence.dao.PersonDao;

public class MySqlDaoFactory extends DaoFactory{

	@Override
	public PersonDao getPersonDao() {
		return new MySqlPersonDao();
	}
}
