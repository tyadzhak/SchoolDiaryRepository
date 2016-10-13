package com.tiad.SchoolDiary.model;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "teacher")
public interface Teacher extends Person {
	<T extends School> T getSchool();
	<T extends Subject> Set<T> getSubjects();
}
