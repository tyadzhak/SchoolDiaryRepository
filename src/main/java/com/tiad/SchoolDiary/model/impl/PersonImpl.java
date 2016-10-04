package com.tiad.SchoolDiary.model.impl;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

import com.tiad.SchoolDiary.model.Person;
import com.tiad.SchoolDiary.model.PersonGender;
import com.tiad.SchoolDiary.persistence.entities.PersonEntity;

@XmlRootElement(name = "Person")
class PersonImpl implements Person {
	private static final long serialVersionUID = -8103095310142859744L;

	private PersonEntity entity;
	
	public PersonImpl() {
		entity = null;
	}
		
	public PersonImpl(PersonEntity ent) {
		this.entity = ent;
	}

	@Override
	public String getFirstName() {
		return entity.getFirstName();
	}
	
	@Override
	public void setFirstName(String name) {
		entity.setFirstName(name);		
	}
	
	@Override
	public String getMiddleName() {
		return entity.getMiddleName();
	}
	
	@Override
	public void setMiddleName(String name) {
		entity.setMiddleName(name);		
	}
	
	@Override
	public String getLastName() {
		return entity.getLastName();
	}
	
	@Override
	public void setLastName(String name) {
		entity.setLastName(name);		
	}
	
	@Override
	public LocalDate getDob() {
		return entity.getDob();
	}
	
	@Override
	public void setDob(LocalDate date) {
		entity.setDob(date);
	}
	
	@Override
	public PersonGender getGender() {
		return entity.getGender();
	}
	
	@Override
	public void setGender(PersonGender gender) {
		entity.setGender(gender);
	}
}
