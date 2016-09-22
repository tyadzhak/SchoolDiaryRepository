package com.tiad.SchoolDiary.persistence.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="parents")
public class ParentEntity {
	
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
	
	//if true then mother, false - father
	@Column(name="isMother")
	private boolean isMother;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="parentsChildrenAttach", joinColumns= {@JoinColumn(name="childId", nullable = false, updatable = false)},
			inverseJoinColumns={@JoinColumn(name="parentId", nullable = false, updatable = false)})
	private Set<ChildEntity> children = new HashSet<ChildEntity>();
	
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

	public boolean isMother() {
		return isMother;
	}

	public void setMother(boolean isMother) {
		this.isMother = isMother;
	}

	public Set<ChildEntity> getChildren() {
		return children;
	}

	public void setChildren(Set<ChildEntity> children) {
		this.children = children;
	}	
}