package com.tiad.SchoolDiary.model;

import java.io.Serializable;
import java.time.LocalDate;

public interface Person extends Serializable  {
	String getFirstName();
	void setFirstName(String name);
	
	String getMiddleName();
	void setMiddleName(String name);
	
	String getLastName();
	void setLastName(String name);
	
	LocalDate getDob();
	void setDob(LocalDate date);
	
	Gender getGender();
	void setGender(Gender gender);
	
	Role getRole();
	void setRole(Role role);
}
