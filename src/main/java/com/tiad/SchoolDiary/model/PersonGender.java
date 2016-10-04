package com.tiad.SchoolDiary.model;


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
    public String getValue() {
        return this.value;
    }

    private final String value;
}
