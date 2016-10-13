package com.tiad.SchoolDiary.model.impl;

import com.tiad.SchoolDiary.model.School;
import com.tiad.SchoolDiary.persistence.entities.impl.SchoolEntityImpl;

public abstract class ModelFactoryCreator {

	public static School createSchool() {
		return new SchoolEntityImpl();
	}
}
