package com.tiad.SchoolDiary.persistence.entities.impl;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tiad.SchoolDiary.persistence.entities.ChildEntity;
import com.tiad.SchoolDiary.persistence.entities.SchoolClassEntity;
import com.tiad.SchoolDiary.persistence.entities.SchoolEntity;

@Entity
@Table(name = "child", schema = "school_diary")
public class ChildEntityImpl extends PersonEntityImpl implements ChildEntity {
	private static final long serialVersionUID = -3892099741901714258L;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = SchoolEntityImpl.class)
	@JoinColumn(name = "school_id", insertable = false, updatable = false, nullable = false, foreignKey = @ForeignKey(name = "fk_child_school_id"))
	private SchoolEntity school;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = SchoolClassEntityImpl.class)
	@JoinColumn(name = "school_class_id", insertable = false, updatable = false, nullable = false, foreignKey = @ForeignKey(name = "fk_child_school_class_id"))
	private SchoolClassEntity schoolClass;

	@Override
	public SchoolEntity getSchool() {
		return school;
	}

	@Override
	public SchoolClassEntity getSchoolClass() {
		return schoolClass;
	}

}
