package com.tiad.SchoolDiary.persistence.dao;

import com.tiad.SchoolDiary.persistence.dao.hsqldb.HsqldbDaoFactory;
import com.tiad.SchoolDiary.persistence.dao.mysql.MySqlDaoFactory;
import com.tiad.SchoolDiary.persistence.entities.SchoolEntity;

public abstract class DaoFactory {
	public static final int MYSQL = 1;
	public static final int HSQLDB = 2;

	public abstract <T extends SchoolEntity> SchoolDao<T> getSchoolDao();

	public static DaoFactory getDaoFactory(int whichFactory) {

		switch (whichFactory) {
		case MYSQL:
			return new MySqlDaoFactory();
		case HSQLDB:
			return new HsqldbDaoFactory();

		default:
			return null;
		}
	}
}
