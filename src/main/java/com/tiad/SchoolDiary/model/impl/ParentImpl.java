package com.tiad.SchoolDiary.model.impl;

import com.tiad.SchoolDiary.model.IName;
import com.tiad.SchoolDiary.model.IPerson;
import com.tiad.SchoolDiary.persistence.Entities.ParentEntity;

public class ParentImpl extends PersonImpl{
	
	private ParentEntity entity;
	public ParentImpl(ParentEntity e) {
		entity = e;
	}

	@Override
	public IName getName() {
		return new NameImpl(entity.getFirstName(), entity.getMiddleName(), entity.getLastName());
	}

	@Override
	public IPerson getParent(boolean mother) throws Exception {
		return null;
		/*
		if(entity.getParents().size() > 2)
			throw new Exception("Broken business rule. Child should have less then 2 parents");
		
		ParentEntity parentEntity = entity.getParents().stream().filter(p -> p.isMother() == mother).findFirst().orElse(null);
		if(parentEntity == null)
			return null;
		
		return new ParentImpl(parentEntity);
		*/
	}
}
