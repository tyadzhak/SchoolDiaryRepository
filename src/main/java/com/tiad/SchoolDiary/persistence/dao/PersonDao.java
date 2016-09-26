package com.tiad.SchoolDiary.persistence.dao;

import com.tiad.SchoolDiary.persistence.entities.PersonEntity;


public interface PersonDao<T extends PersonEntity> {
	void save(T c);
	T getById(long id);
	void deleteById(long id);
	
	/*public int insertPerson(Person p);

	public boolean deletePersin(Person p);

	public Person findPerson(Person p);

	public boolean updatePerson(Person p);*/
}
