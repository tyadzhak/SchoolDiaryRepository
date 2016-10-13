package com.tiad.SchoolDiary.model;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "school")
public interface School extends Serializable {
	String getName();
	void setName(String name);
	
	<T extends SchoolClass> Set<T> getClasses();
	<T extends SchoolClass> void setClasses(Set<T> classes);
	<T extends Teacher> Set<T> getTeachers();
	<T extends Teacher> void setTeachers(Set<T> teachers);
	<T extends Child> Set<T> getChildren();
	<T extends Child> void setChildren(Set<T> children);
}
