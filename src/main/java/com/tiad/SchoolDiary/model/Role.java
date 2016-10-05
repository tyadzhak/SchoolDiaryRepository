package com.tiad.SchoolDiary.model;

import javax.xml.bind.annotation.XmlAttribute;

public enum Role {
	PARENT("Parent"),
	SCHOOL_CHILD("SchoolChild");
	
    private Role(final String v){
        this.value = v;
    }
    
    public static Role of(String value){   	
    	if(value == null)
    		throw new IllegalArgumentException("Value cannot be null");
    	
    	switch (value) {
		case "Parent":
			return PARENT;
			
		case "SchoolChild":
			return SCHOOL_CHILD;

		default:
			throw new IllegalArgumentException("Undefined role type");
		}
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
