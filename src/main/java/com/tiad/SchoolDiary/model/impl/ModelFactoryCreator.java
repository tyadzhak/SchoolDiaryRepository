package com.tiad.SchoolDiary.model.impl;

import com.tiad.SchoolDiary.model.Person;

public abstract class ModelFactoryCreator {
	public static Person createPerson(){
		return new PersonImpl();
	}
}
