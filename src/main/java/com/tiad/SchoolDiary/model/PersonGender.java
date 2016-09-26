package com.tiad.SchoolDiary.model;

import javax.xml.bind.annotation.XmlAttribute;

public enum PersonGender {
	MALE("Male"),
	FEMALE("Female");
	
    private PersonGender(final String v){
        this.value = v;
    }
	
    /**
     * Current string value stored in the enum.
     * @return string value.
     */
    @XmlAttribute(name = "value")
    public String getValue() {
        return this.value;
    }

    private final String value;
}
