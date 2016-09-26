package com.tiad.SchoolDiary.model.impl;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.tiad.SchoolDiary.model.Person;
import com.tiad.SchoolDiary.model.PersonGender;

@XmlRootElement(name = "Person")
class PersonImpl implements Person {
	String firstName;
	String middleName;
	String lastName;
	LocalDate dob;
	PersonGender gender;
	
	@Override
	@XmlElement(name = "firstName")
	public String getFirstName() {
		return firstName;
	}
	
	@Override
	@XmlElement(name = "middleName")
	public String getMiddleName() {
		return middleName;
	}
	
	@Override
	@XmlElement(name = "lastName")
	public String getLastName() {
		return lastName;
	}
	
	@Override
	@XmlElement(name = "dob")
	public LocalDate getDob() {
		return dob;
	}
	
	@Override
	@XmlElement(name = "gender")
	public PersonGender getGender() {
		return gender;
	}
}
