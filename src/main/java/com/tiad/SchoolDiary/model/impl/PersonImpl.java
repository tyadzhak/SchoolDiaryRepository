package com.tiad.SchoolDiary.model.impl;

import com.tiad.SchoolDiary.model.IName;
import com.tiad.SchoolDiary.model.IPerson;

public abstract class PersonImpl implements IPerson{

	@Override
	public abstract IName getName();

	@Override
	public abstract IPerson getParent(boolean mother) throws Exception;

}
