package com.tiad.SchoolDiary.model.impl;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.tiad.SchoolDiary.model.IName;
import com.tiad.SchoolDiary.model.IPerson;
import com.tiad.SchoolDiary.persistence.entities.ChildEntity;
import com.tiad.SchoolDiary.persistence.entities.ParentEntity;

@XmlRootElement(name = "Child")
public class ChildImpl extends PersonImpl {

	private ChildEntity entity;

	public ChildImpl() {

	}

	public ChildImpl(ChildEntity e) {
		entity = e;
	}

	@Override
	@XmlElement(name = "name")
	public IName getName() {
		return new NameImpl(entity.getFirstName(), entity.getMiddleName(),
				entity.getLastName());
	}

	@Override
	@XmlElement(name = "parents")
	public IPerson getParent(boolean mother) throws Exception {
		if (entity.getParents().size() > 2)
			throw new Exception(
					"Broken business rule. Child should have less then 2 parents");

		ParentEntity parentEntity = entity.getParents().stream()
				.filter(p -> p.isMother() == mother).findFirst().orElse(null);
		if (parentEntity == null)
			return null;

		return new ParentImpl(parentEntity);
	}
}