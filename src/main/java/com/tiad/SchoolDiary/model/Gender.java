package com.tiad.SchoolDiary.model;


public enum Gender {
	MALE("Male"),
	FEMALE("Female");
	
    private Gender(final String v){
        this.value = v;
    }
    
    public static Gender of(String value){ 
    	if(value == null)
    		throw new IllegalArgumentException("Value cannot be null");
    	
    	switch (value) {
		case "Male":
			return MALE;
			
		case "Female":
			return FEMALE;

		default:
			throw new IllegalArgumentException("Undefined gender type");
		}
    }

    /**
     * Current string value stored in the enum.
     * @return string value.
     */
    public String getValue() {
        return this.value;
    }

    private final String value;
}
