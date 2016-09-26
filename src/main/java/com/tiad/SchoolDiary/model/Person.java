package com.tiad.SchoolDiary.model;

import java.io.Serializable;
import java.time.LocalDate;

public interface Person extends Serializable  {
	String getFirstName();
	String getMiddleName();
	String getLastName();
	LocalDate getDob();
	PersonGender getGender();
}
