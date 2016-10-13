package com.tiad.SchoolDiary.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.tiad.SchoolDiary.model.adapters.GenderAdapter;

public interface Person extends Serializable  {
	String getFirstName();
	void setFirstName(String name);
	
	String getMiddleName();
	void setMiddleName(String name);
	
	String getLastName();
	void setLastName(String name);
	
	LocalDate getDob();
	void setDob(LocalDate date);
	
	@XmlJavaTypeAdapter(GenderAdapter.class)
	Gender getGender();
	void setGender(Gender gender);
}
