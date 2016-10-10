package com.tiad.SchoolDiary.model.impl;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.tiad.SchoolDiary.model.Person;
import com.tiad.SchoolDiary.model.Role;
import com.tiad.SchoolDiary.model.Gender;
import com.tiad.SchoolDiary.model.adapters.GenderAdapter;
import com.tiad.SchoolDiary.model.adapters.LocalDateAdapter;
import com.tiad.SchoolDiary.model.adapters.RoleAdapter;

@XmlRootElement(name = "Person")
public class PersonImpl implements Person {
	private static final long serialVersionUID = -8103095310142859744L;

	private String firstName;
	private String middleName;
	private String lastName;
	private LocalDate dob;
	private Gender gender;
	private Role role;

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
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getDob() {
		return dob;
	}
	
	@Override
	public void setDob(LocalDate date) {
		dob = date;
	}
	
	@Override
	@XmlJavaTypeAdapter(GenderAdapter.class)
	public Gender getGender() {
		return gender;
	}
	
	@Override
	public void setGender(Gender g) {
		gender = g;
	}
	
	@Override
	@XmlJavaTypeAdapter(RoleAdapter.class)
	public Role getRole() {
		return role;
	}
	
	@Override
	public void setRole(Role r) {
		role = r;
	}
}
