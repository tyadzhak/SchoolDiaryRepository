package com.tiad.SchoolDiary.model.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.tiad.SchoolDiary.model.Gender;

public class GenderAdapter extends XmlAdapter<String, Gender> {

    @Override
    public Gender unmarshal(String genderString) throws Exception {
        return Gender.of(genderString);
    }

    @Override
    public String marshal(Gender gender) throws Exception {
        return gender.getValue();
    }
}