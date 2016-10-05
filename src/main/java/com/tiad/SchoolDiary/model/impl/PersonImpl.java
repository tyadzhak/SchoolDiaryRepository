package com.tiad.SchoolDiary.model.impl;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.tiad.SchoolDiary.model.Person;
import com.tiad.SchoolDiary.model.Gender;
import com.tiad.SchoolDiary.model.adapters.GenderAdapter;
import com.tiad.SchoolDiary.model.adapters.LocalDateAdapter;
import com.tiad.SchoolDiary.persistence.entities.PersonEntity;
import com.tiad.SchoolDiary.persistence.entities.impl.PersonEntityImpl;

@XmlRootElement(name = "Person")
public class PersonImpl implements Person {
	private static final long serialVersionUID = -8103095310142859744L;

	private PersonEntity entity;
	
	public PersonImpl() {
		//todo model do not create instance of entity
		entity = new PersonEntityImpl();
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
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getDob() {
		return entity.getDob();
	}
	
	@Override
	public void setDob(LocalDate date) {
		entity.setDob(date);
	}
	
	@Override
	@XmlJavaTypeAdapter(GenderAdapter.class)
	public Gender getGender() {
		return entity.getGender();
	}
	
	@Override
	public void setGender(Gender gender) {
		entity.setGender(gender);
	}
}
