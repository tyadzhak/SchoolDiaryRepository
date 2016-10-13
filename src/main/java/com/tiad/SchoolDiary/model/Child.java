package com.tiad.SchoolDiary.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "child")
public interface Child extends Person {
	<T extends School > T getSchool();
	<T extends SchoolClass> T getSchoolClass();
}
