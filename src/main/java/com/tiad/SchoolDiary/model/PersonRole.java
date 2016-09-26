package com.tiad.SchoolDiary.model;

import javax.xml.bind.annotation.XmlAttribute;

public enum PersonRole {
	PARENT("Parent"),
	SCHOOL_CHILD("SchoolChild");
	
    private PersonRole(final String v){
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
