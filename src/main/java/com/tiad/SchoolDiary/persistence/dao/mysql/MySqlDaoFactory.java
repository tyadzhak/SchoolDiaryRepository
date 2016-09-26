package com.tiad.SchoolDiary.persistence.dao.mysql;

import com.tiad.SchoolDiary.persistence.dao.DaoFactory;
import com.tiad.SchoolDiary.persistence.dao.PersonDao;
import com.tiad.SchoolDiary.persistence.entities.mysql.MySqlPersonEntity;


public class MySqlDaoFactory extends DaoFactory{

	@Override
	public PersonDao<MySqlPersonEntity> getPersonDao() {
		return new MySqlPersonDao();
	}
}
