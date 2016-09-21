package com.tiad.SchoolDiary.model.impl;

import java.util.HashMap;

import com.tiad.SchoolDiary.model.IName;

public class NameImpl implements IName{
	private HashMap<String, String> nameMap;
	public NameImpl(String fn, String mn, String ln){
		nameMap.put("firstName", fn);
		nameMap.put("middleName", mn);
		nameMap.put("lastName", ln);
	}

	@Override
	public String getFirstName() {
		return nameMap.get("firstName");
	}

	@Override
	public String getMiddleName() {
		return nameMap.get("middleName");
	}

	@Override
	public String getLastName() {
		return nameMap.get("lastName");
	}

	@Override
	public String getFullName() {
		return getFirstName() + " " + getMiddleName() + " " + getLastName();
	}

}
