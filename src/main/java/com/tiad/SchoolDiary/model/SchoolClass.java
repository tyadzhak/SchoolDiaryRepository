package com.tiad.SchoolDiary.model;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "schoolClass")
public interface SchoolClass extends Serializable {
	String getName();
	<T extends School> T getSchool();
	<T extends Child> Set<T> getChildren();
	<T extends Teacher> T getCurator();
	<T extends Subject> Set<T> getSubjects();
}
