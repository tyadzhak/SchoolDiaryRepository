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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tiad.SchoolDiary.persistence.entities.ChildEntity;
import com.tiad.SchoolDiary.persistence.entities.SchoolClassEntity;
import com.tiad.SchoolDiary.persistence.entities.SchoolEntity;
import com.tiad.SchoolDiary.persistence.entities.SubjectEntity;
import com.tiad.SchoolDiary.persistence.entities.TeacherEntity;

@Entity
@Table(name = "school_class", schema = "school_diary")
public class SchoolClassEntityImpl implements SchoolClassEntity {
	private static final long serialVersionUID = -1056547439994153144L;

	@Column(name = "name")
	private String name;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = SchoolEntityImpl.class)
	@JoinColumn(name = "school_id", insertable = false, updatable = false, nullable = false, foreignKey= @ForeignKey(name="fk_school_class_school_id"))
	private SchoolEntity school;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="schoolClass", targetEntity=ChildEntityImpl.class)
	private Set<ChildEntity> children;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = TeacherEntityImpl.class)
	@JoinColumn(name = "curator_id", insertable = false, updatable = false, nullable = false, foreignKey=@ForeignKey(name="fk_school_class_curator_id"))
	private TeacherEntity curator;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="schoolClass", targetEntity=SubjectEntityImpl.class)
	private Set<SubjectEntity> subjects;

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "school_class_sequence", schema = "school_diary")
	private long id;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public SchoolEntity getSchool() {
		return school;
	}

	@Override
	public Set<ChildEntity> getChildren() {
		return children;
	}

	@Override
	public TeacherEntity getCurator() {
		return curator;
	}

	@Override
	public Set<SubjectEntity> getSubjects() {
		return subjects;
	}

	@Override
	public long getId() {
		return id;
	}

}
