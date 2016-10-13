package com.tiad.SchoolDiary.persistence.entities.impl;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tiad.SchoolDiary.persistence.entities.SchoolClassEntity;
import com.tiad.SchoolDiary.persistence.entities.SubjectEntity;
import com.tiad.SchoolDiary.persistence.entities.TeacherEntity;

@Entity
@Table(name="subject", schema="school_diary")
public class SubjectEntityImpl implements SubjectEntity{
	private static final long serialVersionUID = -6110846131756197585L;

	@Column(name = "name")
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="subjects", targetEntity=TeacherEntityImpl.class)
	private Set<TeacherEntity> teachers;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = SchoolClassEntityImpl.class)
	@JoinColumn(name = "school_class_id", insertable = false, updatable = false, nullable = false, foreignKey=@ForeignKey(name="fk_subject_school_class_id"))
	private SchoolClassEntity schoolClass;
	
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "subject_sequence", schema = "school_diary")
	private long id;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Set<TeacherEntity> getTeachers() {
		return teachers;
	}

	@Override
	public SchoolClassEntity getSchoolClass() {
		return schoolClass;
	}

	@Override
	public long getId() {
		return id;
	}

}
