package com.tiad.SchoolDiary.persistence.dao.mysql;

import com.tiad.SchoolDiary.persistence.dao.DaoFactory;
import com.tiad.SchoolDiary.persistence.dao.SchoolDao;

public class MySqlDaoFactory extends DaoFactory{
	
	@Override
	public SchoolDao getSchoolDao() {
		return new MySqlSchoolDao();
	}
}
