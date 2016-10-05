package com.tiad.SchoolDiary.model.adapters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String dateString) throws Exception {
        return LocalDate.parse(dateString);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return	DateTimeFormatter.ISO_LOCAL_DATE.format(localDate);
    }
}