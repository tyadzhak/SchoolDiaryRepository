package com.tiad.SchoolDiary.persistence.dao.hsqldb;

import com.tiad.SchoolDiary.persistence.dao.DaoFactory;
import com.tiad.SchoolDiary.persistence.dao.SchoolDao;

public class HsqldbDaoFactory extends DaoFactory{

	@Override
	public SchoolDao getSchoolDao() {
		return new HsqldbSchoolDao();
	}
}
