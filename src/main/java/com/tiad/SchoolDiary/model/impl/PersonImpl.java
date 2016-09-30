package com.tiad.SchoolDiary.model.impl;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.tiad.SchoolDiary.model.Person;
import com.tiad.SchoolDiary.model.PersonGender;

@XmlRootElement(name = "Person")
class PersonImpl implements Person {
	private static final long serialVersionUID = -8103095310142859744L;
	
	@XmlElement(name = "firstName")
	private String firstName;
	
	@XmlElement(name = "middleName")
	private String middleName;
	
	@XmlElement(name = "lastName")
	private String lastName;
	
	@XmlElement(name = "dob")
	private LocalDate dob;
	
	@XmlElement(name = "gender")
	private PersonGender gender;
	
	@Override

	public String getFirstName() {
		return firstName;
	}
	
	@Override
	public void setFirstName(String name) {
		firstName = name;		
	}
	
	@Override
	
	public String getMiddleName() {
		return middleName;
	}
	
	@Override
	public void setMiddleName(String name) {
		middleName = name;		
	}
	
	@Override
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public void setLastName(String name) {
		lastName = name;		
	}
	
	@Override
	public LocalDate getDob() {
		return dob;
	}
	
	@Override
	public void setDob(LocalDate date) {
		dob = date;
	}
	
	@Override
	public PersonGender getGender() {
		return gender;
	}
	
	@Override
	public void setGender(PersonGender gender) {
		this.gender = gender;
	}
}
