package com.tiad.SchoolDiary.persistence.entities.impl;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tiad.SchoolDiary.persistence.entities.SchoolEntity;
import com.tiad.SchoolDiary.persistence.entities.SubjectEntity;
import com.tiad.SchoolDiary.persistence.entities.TeacherEntity;

@Entity
@Table(name = "teacher", schema = "school_diary")
public class TeacherEntityImpl extends PersonEntityImpl implements
		TeacherEntity {
	private static final long serialVersionUID = -674759248467764665L;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = SchoolEntityImpl.class)
	@JoinColumn(name = "school_id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_teacher_school_id"))
	private SchoolEntity school;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = SubjectEntityImpl.class)
	@JoinTable(name = "teacher_subject", schema = "school_diary", joinColumns = { 
			@JoinColumn(name = "teacher_id", nullable = false, updatable = false, insertable = false,
					foreignKey = @ForeignKey(name = "fk_teacher_subject_id")) }, 
			inverseJoinColumns = {@JoinColumn(name = "subject_id", nullable = false, updatable = false,  insertable = false,
					foreignKey = @ForeignKey(name = "fk_subject_teacher_id")) })
	private Set<SubjectEntity> subjects;

	@Override
	public SchoolEntity getSchool() {
		return school;
	}

	@Override
	public Set<SubjectEntity> getSubjects() {
		return subjects;
	}

}
