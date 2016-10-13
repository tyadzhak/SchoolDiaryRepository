package com.tiad.SchoolDiary.model;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "subject")
public interface Subject extends Serializable{
	String getName();
	<T extends Teacher> Set<T> getTeachers();
	<T extends SchoolClass> T getSchoolClass();
}
