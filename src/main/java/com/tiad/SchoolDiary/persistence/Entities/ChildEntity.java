package com.tiad.SchoolDiary.persistence.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tiad.SchoolDiary.model.IName;

@Entity
@Table(name="children")
public class ChildEntity{
	
	@Id
	@Column(name="recId", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@SequenceGenerator(name="children_sequence")
	private long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="middleName")
	private String middleName;
	
	@Column(name="lastName")
	private String lastName;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "children")
	private Set<ParentEntity> parents = new HashSet<ParentEntity>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Set<ParentEntity> getParents() {
		return parents;
	}

	public void setParents(Set<ParentEntity> parents) {
		this.parents = parents;
	}
}
