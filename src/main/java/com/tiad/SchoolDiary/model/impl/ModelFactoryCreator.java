package com.tiad.SchoolDiary.model.impl;

import com.tiad.SchoolDiary.model.Person;
import com.tiad.SchoolDiary.persistence.entities.PersonEntity;
import com.tiad.SchoolDiary.persistence.entities.impl.PersonEntityImpl;

public abstract class ModelFactoryCreator {
	public static Person createPerson(PersonEntity ent){
		return mapFromEntity(ent);
	}
	
	public static PersonEntity createPerson(Person model){
		return mapFromModel(model);
	}
	
	private static void map(Person from, Person to){
		to.setFirstName(from.getFirstName());
		to.setMiddleName(from.getMiddleName());
		to.setLastName(from.getLastName());
		to.setDob(from.getDob());
		to.setGender(from.getGender());
		to.setRole(from.getRole());
	}
	
	private static Person mapFromEntity(PersonEntity ent){
		Person person = new PersonImpl();
		map(ent, person);
		
		return person;
	}
	
	private static PersonEntity mapFromModel(Person model){
		PersonEntity person = new PersonEntityImpl();
		map(model, person);
		
		return person;
	}
}
