package com.tiad.SchoolDiary.persistence.dao;

import com.tiad.SchoolDiary.persistence.dao.mysql.MySqlDaoFactory;
import com.tiad.SchoolDiary.persistence.entities.PersonEntity;

public abstract class DaoFactory {
	public static final int MYSQL = 1;

	public abstract <T extends PersonEntity> PersonDao<T> getPersonDao();

	public static DaoFactory getDaoFactory(int whichFactory) {

		switch (whichFactory) {
		case MYSQL:
			return new MySqlDaoFactory();
		default:
			return null;
		}
	}
}
