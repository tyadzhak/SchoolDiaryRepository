package com.tiad.SchoolDiary.persistence.entities.impl;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tiad.SchoolDiary.model.Child;
import com.tiad.SchoolDiary.model.SchoolClass;
import com.tiad.SchoolDiary.model.Teacher;
import com.tiad.SchoolDiary.persistence.entities.ChildEntity;
import com.tiad.SchoolDiary.persistence.entities.SchoolClassEntity;
import com.tiad.SchoolDiary.persistence.entities.SchoolEntity;
import com.tiad.SchoolDiary.persistence.entities.TeacherEntity;

@Entity
@Table(name = "school", schema = "school_diary")
public class SchoolEntityImpl implements SchoolEntity{
	private static final long serialVersionUID = -782168613232593342L;
	
	public SchoolEntityImpl() {
	
	}
	
	public SchoolEntityImpl(String name, Set<SchoolClassEntity> classes, Set<TeacherEntity> teacher, Set<ChildEntity> children) {
		this.name = name;
		this.classes = classes;
		this.teachers = teacher;
		this.children = children;
	}

	@Column(name = "name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="school", targetEntity=SchoolClassEntityImpl.class)
	private Set<SchoolClassEntity> classes;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="school", targetEntity=TeacherEntityImpl.class)
	private Set<TeacherEntity> teachers;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="school", targetEntity=ChildEntityImpl.class)
	private Set<ChildEntity> children;
	
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "school_sequence", schema = "school_diary")
	private long id;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Set<SchoolClassEntity> getClasses() {
		return classes;
	}
	
	@Override
	public <T extends SchoolClass> void setClasses(Set<T> classes){
		this.classes = (Set<SchoolClassEntity>) classes;
	}

	@Override
	public Set<TeacherEntity> getTeachers() {
		return teachers;
	}
	
	@Override
	public <T extends Teacher> void setTeachers(Set<T> teachers){
		this.teachers = (Set<TeacherEntity>) teachers;
	}

	@Override
	public Set<ChildEntity> getChildren() {
		return children;
	}
	
	@Override
	public <T extends Child> void setChildren(Set<T> children){
		this.children = (Set<ChildEntity>) children;
	}

	@Override
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	/*@Override
	public String toString(){
		return getName() + " id: " + getId();
	}*/

}
