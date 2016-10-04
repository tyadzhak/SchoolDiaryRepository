package com.tiad.SchoolDiary.model.impl;

import com.tiad.SchoolDiary.model.Person;
import com.tiad.SchoolDiary.persistence.entities.PersonEntity;

public abstract class ModelFactoryCreator {
	public static Person createPerson(PersonEntity ent){
		return new PersonImpl(ent);
	}
}
